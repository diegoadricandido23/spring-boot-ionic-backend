/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 4 de fev de 2019
 *
 */
package com.diego.cursomc.resources;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diego.cursomc.dto.EmailDTO;
import com.diego.cursomc.security.JWTUtil;
import com.diego.cursomc.security.UsuarioSS;
import com.diego.cursomc.services.AuthService;
import com.diego.cursomc.services.UserService;

/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * 4 de fev de 2019
 */
@RestController
@RequestMapping(value="/auth")
public class AuthResources {

	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthService service;
	
	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UsuarioSS user = UserService.authenticated();
		String token = jwtUtil.generatedToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDto) {
		service.sendNewPassword(objDto.getEmail());
		return ResponseEntity.noContent().build();
	}
}