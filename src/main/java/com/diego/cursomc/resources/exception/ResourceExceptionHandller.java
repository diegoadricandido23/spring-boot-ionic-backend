/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 14 de jun de 2018
 *
 */
package com.diego.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.diego.cursomc.services.exception.ObjectNotFoudException;

/**
 * @author diego
 *
 */
@ControllerAdvice
public class ResourceExceptionHandller {
	
	@ExceptionHandler(ObjectNotFoudException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoudException e, HttpServletRequest request){
		
		StandardError  standardError = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
	}
}
