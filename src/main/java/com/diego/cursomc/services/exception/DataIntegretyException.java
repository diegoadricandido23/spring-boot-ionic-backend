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
public class DataIntegretyException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DataIntegretyException(String msg) {
		super(msg);
	}
	
	public DataIntegretyException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
