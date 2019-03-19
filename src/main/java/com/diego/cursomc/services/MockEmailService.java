/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 12 de dez de 2018
 *
 */
package com.diego.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import com.diego.cursomc.domain.Pedido;

/**
 * @author diego
 *
 */
public class MockEmailService extends AbstractEmailService{

	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de email ...");
		LOG.info(msg.toString());
		LOG.info("Email Enviado");
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Simulando envio de email HTML...");
		LOG.info(msg.toString());
		LOG.info("Email Enviado HTML");
	}

	@Override
	public void sendOrderConfirmationHtmlEmail(Pedido pedido) {
		LOG.info("Simulando envio de email Confirmacao de Pedido...");
		LOG.info(pedido.toString());
		LOG.info("Email Enviado");
	}
}
