/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 20 de jun de 2018
 *
 */
package com.diego.cursomc.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.diego.cursomc.domain.Cliente;

/**
 * @author diego
 *
 */
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	
	@NotEmpty(message = "Preenchimento Obrigatorio")
	@Length(min=5, max = 120, message = "O Tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotEmpty(message = "Preenchimento Obrigatorio")
	@Email(message = "Email invalido")
	private String email;
	
	public ClienteDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ClienteDTO(Cliente cliente) {
		id = cliente.getId();
		nome = cliente.getNome();
		email = cliente.getEmail();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
