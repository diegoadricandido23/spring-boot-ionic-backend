/**
 * 
 */
package com.diego.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diego.cursomc.domain.Categoria;
import com.diego.cursomc.services.CategoriaService;

/**
 * @author Diego Adriano
 * @since 07/06/2018
 *
 */
@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) {
		
		Categoria categoria = categoriaService.find(id);

		return ResponseEntity.ok().body(categoria);
	}
	
}