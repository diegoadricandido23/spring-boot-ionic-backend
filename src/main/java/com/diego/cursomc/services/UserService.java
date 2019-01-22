/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 21 de jan de 2019
 *
 */
package com.diego.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.diego.cursomc.security.UsuarioSS;

/**
 * @author Diego Adriano
 *
 */
public class UserService {
	
	public static UsuarioSS authenticated() {
		try {
			return (UsuarioSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
}
