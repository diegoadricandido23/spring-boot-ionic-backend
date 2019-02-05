/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 4 de fev de 2019
 *
 */
package com.diego.cursomc.resources;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diego.cursomc.security.JWTUtil;
import com.diego.cursomc.security.UsuarioSS;
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
	
	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response){
		UsuarioSS usuarioSS = UserService.authenticated();
		String token = jwtUtil.generatedToken(usuarioSS.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		return ResponseEntity.noContent().build();
	}
}