package com.ceiba.pelicula.adaptador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.pelicula.modelo.entidad.Pelicula;

public interface RepositorioPeliculaJPA extends JpaRepository<Pelicula, Long> {
	
	boolean existsByNombre(String nombre);
	Pelicula findByNombre(String nombre);
}
