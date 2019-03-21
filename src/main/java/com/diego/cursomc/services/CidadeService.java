/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 20 de mar de 2019
 *
 */
package com.diego.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.cursomc.domain.Cidade;
import com.diego.cursomc.repositories.CidadeRepository;

/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * 20 de mar de 2019
 */
@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;

	public List<Cidade> findByEstado(Integer estadoId) {
		return repo.findCidades(estadoId);
	}
}