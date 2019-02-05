/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 4 de fev de 2019
 *
 */
package com.diego.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * 4 de fev de 2019
 */
public class EmailDTO implements Serializable{

private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;
	
	public EmailDTO() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
