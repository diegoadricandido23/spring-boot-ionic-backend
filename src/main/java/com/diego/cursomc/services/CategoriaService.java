/**
 * 
 */
package com.diego.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.cursomc.domain.Categoria;
import com.diego.cursomc.repositories.CategoriaRepository;
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
	
}