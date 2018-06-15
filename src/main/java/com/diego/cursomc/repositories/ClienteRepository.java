/**
 * 
 */
package com.diego.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diego.cursomc.domain.Cidade;
import com.diego.cursomc.domain.Cliente;

/**
 * @authorDiego Adriano
 * @since 
 *
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
}