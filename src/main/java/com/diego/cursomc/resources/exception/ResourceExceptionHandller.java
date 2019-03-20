/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 14 de jun de 2018
 *
 */
package com.diego.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.diego.cursomc.services.exception.AuthorizationException;
import com.diego.cursomc.services.exception.DataIntegretyException;
import com.diego.cursomc.services.exception.FileException;
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
	
	@ExceptionHandler(DataIntegretyException.class)
	public ResponseEntity<StandardError> dataIntegrety(DataIntegretyException e, HttpServletRequest request){
		
		StandardError  standardError = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
		
		ValidationError  validationError = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de Validacao", System.currentTimeMillis());
		
		for(FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			validationError.addError(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(validationError);
	}
	
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest request){
		
		StandardError  standardError = new StandardError(HttpStatus.FORBIDDEN.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(standardError);
	}
	
	@ExceptionHandler(FileException.class)
	public ResponseEntity<StandardError> file(AuthorizationException e, HttpServletRequest request){
		
		StandardError  standardError = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
	}
	
	@ExceptionHandler(AmazonServiceException.class)
	public ResponseEntity<StandardError> amazonService(AmazonServiceException e, HttpServletRequest request){
		HttpStatus code = HttpStatus.valueOf(e.getErrorCode());
		StandardError  standardError = new StandardError(code.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(code).body(standardError);
	}
	
	@ExceptionHandler(AmazonClientException.class)
	public ResponseEntity<StandardError> amazonClient(AmazonClientException e, HttpServletRequest request){
		StandardError  standardError = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(standardError);
	}
	
	@ExceptionHandler(AmazonS3Exception.class)
	public ResponseEntity<StandardError> amazonS3t(AmazonS3Exception e, HttpServletRequest request){
		StandardError  standardError = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(standardError);
	}
}
