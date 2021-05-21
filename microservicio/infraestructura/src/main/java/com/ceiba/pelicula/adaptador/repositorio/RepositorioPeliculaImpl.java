package com.ceiba.pelicula.adaptador.repositorio;

import org.springframework.stereotype.Repository;

import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;

@Repository
public class RepositorioPeliculaImpl implements RepositorioPelicula {

	private final RepositorioPeliculaJPA repositorio;
	
	public RepositorioPeliculaImpl(RepositorioPeliculaJPA repositorioPeliculaJPA) {
		this.repositorio = repositorioPeliculaJPA;
	}
	
	@Override
	public boolean existe(String nombre) {
		return this.repositorio.existsByNombre(nombre);
	}

	@Override
	public Long crear(Pelicula peliculaInicial) {
		Pelicula pelicula = this.repositorio.save(peliculaInicial);
		return pelicula.getId();
	}

}
