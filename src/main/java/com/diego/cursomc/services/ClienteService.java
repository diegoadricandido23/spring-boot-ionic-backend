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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diego.cursomc.domain.Cidade;
import com.diego.cursomc.domain.Cliente;
import com.diego.cursomc.domain.Endereco;
import com.diego.cursomc.domain.enums.Perfil;
import com.diego.cursomc.domain.enums.TipoCliente;
import com.diego.cursomc.dto.ClienteDTO;
import com.diego.cursomc.dto.ClienteNewDTO;
import com.diego.cursomc.repositories.ClienteRepository;
import com.diego.cursomc.repositories.EnderecoRepository;
import com.diego.cursomc.security.UsuarioSS;
import com.diego.cursomc.services.exception.AuthorizationException;
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
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@SuppressWarnings("null")
	public Cliente find(Integer id) {
		UsuarioSS usuarioSS = UserService.authenticated();
		if(usuarioSS != null || !usuarioSS.hashole(Perfil.ADMIN) && !id.equals(usuarioSS.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoudException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getSimpleName())
				);
	}
	
	@Transactional
	public Cliente insert(Cliente cliente) {
		cliente.setId(null);
		cliente = repository.save(cliente);
		enderecoRepository.saveAll(cliente.getEnderecos());
		return cliente;
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
		return new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getEmail(), null, null, null);
	}
	
	public Cliente fromDTO(ClienteNewDTO clienteNewDTO) {
		Cliente cliente = new Cliente(null, 
				clienteNewDTO.getNome(), 
				clienteNewDTO.getEmail(), 
				clienteNewDTO.getCpfOuCnpj(), 
				TipoCliente.toEnum(clienteNewDTO.getTipo()), 
				bCryptPasswordEncoder.encode(clienteNewDTO.getSenha())
			);
		Cidade cidade = new Cidade(clienteNewDTO.getCidadeId(), null, null);
		Endereco endereco = new Endereco(null, clienteNewDTO.getLogradouro(), clienteNewDTO.getNumero(), clienteNewDTO.getComplemento(),
				clienteNewDTO.getBairro(), clienteNewDTO.getCep(), cliente, cidade);
		
		cliente.getEnderecos().add(endereco);
		cliente.getTelefones().add(clienteNewDTO.getTelefone1());
		if(clienteNewDTO.getTelefone2() != null)
			cliente.getTelefones().add(clienteNewDTO.getTelefone2());
		if(clienteNewDTO.getTelefone3() != null)
			cliente.getTelefones().add(clienteNewDTO.getTelefone2());;
		
		return cliente;
	}
	
	private void updateData(Cliente novoCliente, Cliente antigoCliente) {
		novoCliente.setNome(antigoCliente.getNome());
		novoCliente.setEmail(antigoCliente.getEmail());
	}
}