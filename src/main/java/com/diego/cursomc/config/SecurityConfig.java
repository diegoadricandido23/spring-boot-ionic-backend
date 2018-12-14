/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 13 de dez de 2018
 *
 */
package com.diego.cursomc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;;

/**
 * @author diego
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private Environment environment;
	
	private static final String[] PUBLIC_MATCHERS = { 
			"/2-console/**"
		};
	
	private static final String[] PUBLIC_MATCHERS_GET = { 
			"/produtos/**", 
			"/categorias/**" 
		};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		if(Arrays.asList(environment.getActiveProfiles()).contains("test")){
			http.headers().frameOptions().disable();
		}
		
		http.cors().and().csrf().disable();
		http.authorizeRequests()
		.antMatchers(PUBLIC_MATCHERS).permitAll()
		.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
		.anyRequest().authenticated();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
	final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
	return source;
	}
}