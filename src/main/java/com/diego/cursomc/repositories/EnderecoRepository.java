/**
 * 
 */
package com.diego.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diego.cursomc.domain.Endereco;

/**
 * @authorDiego Adriano
 * @since 
 *
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
	
}