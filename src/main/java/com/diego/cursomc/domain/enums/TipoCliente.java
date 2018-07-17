/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 14 de jun de 2018
 *
 */
package com.diego.cursomc.domain.enums;

/**
 * @author diego
 *
 */
public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Física"), 
	PESSOAJURICA(2, "Pessoa Juridica");
	
	private int cod;
	private String descricao;

	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer codigo) {
		if(codigo == null)
			return null;
		for(TipoCliente x : TipoCliente.values()) {
			if(codigo.equals(x.getCod()))
				return x;
		}
		throw new IllegalArgumentException("Id Inválido: " + codigo);
	}
}