/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 21 de jan de 2019
 *
 */
package com.diego.cursomc.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author Diego Adriano
 *
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	private JWTUtil jwtUtil;

	private UserDetailsService userDetailsService;

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil,
			UserDetailsService userDetailsService) {
		super(authenticationManager);
		this.jwtUtil = jwtUtil;
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String header = request.getHeader("Authorizartion");

		if (header != null && header.startsWith("Bearer ")) {
			UsernamePasswordAuthenticationToken authenticationToken = getAutentcation(header.substring(7));
			if (authenticationToken != null) {
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		chain.doFilter(request, response);
	}

	public UsernamePasswordAuthenticationToken getAutentcation(String token) {
		if(jwtUtil.tokenValido(token)) {
			String userName = jwtUtil.getUserName(token);
			UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
			return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		}
		return null;
	}

}
