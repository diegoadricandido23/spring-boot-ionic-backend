/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 18 de jul de 2018
 *
 */
package com.diego.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author diego
 *
 */
@Configuration
@Profile("test")
public class TesteConfig {

	@Autowired
	private DBService dbService;

	@Bean
	public boolean instantiateDataBase() throws ParseException {
		dbService.instatiateDataBase();
		return true;
	}
}