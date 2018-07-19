/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 18 de jul de 2018
 *
 */
package com.diego.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author diego
 *
 */
@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDataBase() throws ParseException {
		
		if(!"create".equals(strategy)) {
			return false;
		}
		dbService.instatiateDataBase();
		return true;
	}
}