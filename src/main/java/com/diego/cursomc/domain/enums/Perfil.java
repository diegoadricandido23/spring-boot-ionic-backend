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
public enum Perfil {
	
	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");
	
	private int cod;
	private String descricao;

	private Perfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Perfil toEnum(Integer codigo) {
		if(codigo == null)
			return null;
		for(Perfil x : Perfil.values()) {
			if(codigo.equals(x.getCod()))
				return x;
		}
		throw new IllegalArgumentException("Id Inválido: " + codigo);
	}
}
