/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 12 de dez de 2018
 *
 */
package com.diego.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.diego.cursomc.domain.Pedido;

/**
 * @author diego
 *
 */
public class SmtpEmailService extends AbstractEmailService{
	
	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Enviando de email ...");
		mailSender.send(msg);
		LOG.info("Email Enviado");
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Enviando de email ...");
		javaMailSender.send(msg);
		LOG.info("Email Enviado");
	}

	@Override
	public void sendOrderConfirmationHtmlEmail(Pedido pedido) {
		LOG.info("Enviando de email Pedido...");
		javaMailSender.send(pedido.toString());
		LOG.info("Email Enviado");
	}

}