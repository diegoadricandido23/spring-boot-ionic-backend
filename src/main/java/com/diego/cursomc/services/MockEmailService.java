/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 12 de dez de 2018
 *
 */
package com.diego.cursomc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

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
}
