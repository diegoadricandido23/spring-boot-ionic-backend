/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 20 de jun de 2018
 *
 */
package com.diego.cursomc.resources.exception;

import java.io.Serializable;

/**
 * @author diego
 *
 */
public class FieldMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	private String fieldName;
	private String message;
	
	public FieldMessage() {
		// TODO Auto-generated constructor stub
	}

	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
