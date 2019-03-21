/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 20 de mar de 2019
 *
 */
package com.diego.cursomc.dto;

import java.io.Serializable;

import com.diego.cursomc.domain.Cidade;

/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * 20 de mar de 2019
 */
public class CidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;

	public CidadeDTO() {
	}

	public CidadeDTO(Cidade obj) {
		id = obj.getId();
		nome = obj.getNome();
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
}