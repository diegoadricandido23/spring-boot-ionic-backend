/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 20 de mar de 2019
 *
 */
package com.diego.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.cursomc.domain.Estado;
import com.diego.cursomc.repositories.EstadoRepository;

/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * 20 de mar de 2019
 */
@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repo;

	public List<Estado> findAll() {
		return repo.findAllByOrderByNome();
	}
}