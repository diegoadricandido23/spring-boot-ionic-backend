/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 14 de jun de 2018
 *
 */
package com.diego.cursomc.services.exception;

/**
 * @author diego
 *
 */
public class ObjectNotFoudException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoudException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoudException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
