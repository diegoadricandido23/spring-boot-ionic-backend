/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 21 de jun de 2018
 *
 */
package com.diego.cursomc.services.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author diego
 *
 */
@Constraint(validatedBy = ClienteInsertValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ClienteInsert {
	
	String message() default "Erro de validacao";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
