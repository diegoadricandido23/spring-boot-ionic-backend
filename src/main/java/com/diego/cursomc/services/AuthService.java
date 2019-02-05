/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 4 de fev de 2019
 *
 */
package com.diego.cursomc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.diego.cursomc.domain.Cliente;
import com.diego.cursomc.repositories.ClienteRepository;
import com.diego.cursomc.services.exception.ObjectNotFoudException;

/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * 4 de fev de 2019
 */
@Service
public class AuthService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;
	
	private Random random = new Random();
	
	public void sendNewPassword(String email) {
		
		Cliente cliente = clienteRepository.findByEmail(email);
		if(cliente == null) {
			throw new ObjectNotFoudException("Email não encontrado");
		}
		String newPass = newPassword();
		cliente.setSenha(pe.encode(newPass));
		
		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPass);
	}
	
	private String newPassword() {
		char [] vet = new char[10];
		for(int i=0; i<10; i++) {
			vet[i] = ramdomChar();
		}
		return new String(vet);
	}
	
	private char ramdomChar() {
		int opt = random.nextInt(3);
		if(opt == 0) {
			return (char) (random.nextInt(10) +48);
		}
		else if(opt == 1) {
			return (char) (random.nextInt(26) +65);
		}
		else {
			return (char) (random.nextInt(26) +97);
		}
	}
}
