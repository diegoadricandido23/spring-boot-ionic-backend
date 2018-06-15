/**
 * 
 */
package com.diego.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diego.cursomc.domain.Estado;

/**
 * @authorDiego Adriano
 * @since 
 *
 */
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{
	
}