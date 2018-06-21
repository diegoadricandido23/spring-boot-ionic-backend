/**
 * 
 */
package com.diego.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.diego.cursomc.domain.Cliente;
import com.diego.cursomc.dto.ClienteDTO;
import com.diego.cursomc.repositories.ClienteRepository;
import com.diego.cursomc.services.exception.DataIntegretyException;
import com.diego.cursomc.services.exception.ObjectNotFoudException;

/**
 * @author Diego Adriano
 *
 */
@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public Cliente find(Integer id) {
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoudException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getSimpleName())
				);
	}
	
	public Cliente insert(Cliente cliente) {
		cliente.setId(null);
		return repository.save(cliente);
	}
	
	public Cliente update(Cliente cliente) {
		Cliente novoCliente =  find(cliente.getId());
		updateData(novoCliente, cliente);
		return repository.save(novoCliente);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegretyException("Nao e possivel excluir porque ha entidades relacionas");
		}
		
	}
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		@SuppressWarnings("deprecation")
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO clienteDTO) {
		return new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getEmail(), null, null);
	}
	
	private void updateData(Cliente novoCliente, Cliente antigoCliente) {
		novoCliente.setNome(antigoCliente.getNome());
		novoCliente.setEmail(antigoCliente.getEmail());
	}
}