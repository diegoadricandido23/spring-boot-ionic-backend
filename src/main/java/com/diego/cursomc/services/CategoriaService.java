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

import com.diego.cursomc.domain.Categoria;
import com.diego.cursomc.dto.CategoriaDTO;
import com.diego.cursomc.repositories.CategoriaRepository;
import com.diego.cursomc.services.exception.DataIntegretyException;
import com.diego.cursomc.services.exception.ObjectNotFoudException;

/**
 * @author Diego Adriano
 *
 */
@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria find(Integer id) {
		Optional<Categoria> categoria = repository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoudException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getSimpleName())
				);
	}
	
	public Categoria insert(Categoria categoria) {
		categoria.setId(null);
		return repository.save(categoria);
	}
	
	public Categoria update(Categoria categoria) {
		Categoria novoCategoria =  find(categoria.getId());
		updateData(novoCategoria, categoria);
		return repository.save(novoCategoria);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegretyException("Nao e possivel excluir porque ha entidades relacionas");
		}
		
	}
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		@SuppressWarnings("deprecation")
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	public Categoria fromDTO(CategoriaDTO categoriaDTO) {
		return new Categoria(categoriaDTO.getId(), categoriaDTO.getNome());
	}
	
	private void updateData(Categoria novoCategoria, Categoria antigoCategoria) {
		novoCategoria.setNome(antigoCategoria.getNome());
	}
}	