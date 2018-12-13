package com.diego.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.diego.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido pedido);
	void sendEmail(SimpleMailMessage msg);
}
