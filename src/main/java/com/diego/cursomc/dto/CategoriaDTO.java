/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 20 de jun de 2018
 *
 */
package com.diego.cursomc.dto;

import java.io.Serializable;

import com.diego.cursomc.domain.Categoria;

/**
 * @author diego
 *
 */
public class CategoriaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	
	public CategoriaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CategoriaDTO(Categoria categoria) {
		id = categoria.getId();
		nome = categoria.getNome();
	}
	
	public CategoriaDTO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
