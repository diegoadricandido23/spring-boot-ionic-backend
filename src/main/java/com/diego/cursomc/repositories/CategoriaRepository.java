/**
 * 
 */
package com.diego.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diego.cursomc.domain.Categoria;

/**
 * @authorDiego Adriano
 * @since 
 *
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
}