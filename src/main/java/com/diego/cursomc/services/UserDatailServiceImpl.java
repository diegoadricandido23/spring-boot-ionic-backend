/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 15 de jan de 2019
 *
 */
package com.diego.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.diego.cursomc.domain.Cliente;
import com.diego.cursomc.repositories.ClienteRepository;
import com.diego.cursomc.security.UsuarioSS;

/**
 * @author diego
 *
 */
@Service
public class UserDatailServiceImpl implements UserDetailsService{
	
	@Autowired
	private ClienteRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Cliente cliente = repository.findByEmail(email);
		if(cliente == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UsuarioSS(cliente.getId(), cliente.getEmail(), cliente.getSenha(), cliente.getPerfis());
	}

}
