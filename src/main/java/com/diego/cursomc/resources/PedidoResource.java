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

import com.diego.cursomc.domain.Pedido;
import com.diego.cursomc.services.PedidoService;

/**
 * @author Diego Adriano
 * @since 07/06/2018
 *
 */
@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) {
		
		Pedido categoria = service.find(id);

		return ResponseEntity.ok().body(categoria);
	}
	
}