/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 21 de jun de 2018
 *
 */
package com.diego.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.diego.cursomc.domain.Cliente;
import com.diego.cursomc.domain.enums.TipoCliente;
import com.diego.cursomc.dto.ClienteNewDTO;
import com.diego.cursomc.repositories.ClienteRepository;
import com.diego.cursomc.resources.exception.FieldMessage;
import com.diego.cursomc.services.validation.utils.BR;

/**
 * @author diego
 *
 */
public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert constraintAnnotation) {

	}

	@Override
	public boolean isValid(ClienteNewDTO clienteNewDTO, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if (clienteNewDTO.getTipo().equals(TipoCliente.PESSOAFISICA.getCod())
				&& !BR.isValidCpf(clienteNewDTO.getCpfOuCnpj()))
			list.add(new FieldMessage("cpfOuCnpj", "CPF Invalido"));

		if (clienteNewDTO.getTipo().equals(TipoCliente.PESSOAJURICA.getCod())
				&& !BR.isValidCnpj(clienteNewDTO.getCpfOuCnpj()))
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ Invalido"));
		
		Cliente aux = repo.findByEmail(clienteNewDTO.getEmail());
		if(aux != null)
			list.add(new FieldMessage("email", "Email ja Cadastrado"));
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
			.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
