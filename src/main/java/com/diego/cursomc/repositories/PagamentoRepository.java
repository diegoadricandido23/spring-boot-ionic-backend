/**
 * 
 */
package com.diego.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diego.cursomc.domain.Pagamento;

/**
 * @authorDiego Adriano
 * @since 
 *
 */
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{
	
}