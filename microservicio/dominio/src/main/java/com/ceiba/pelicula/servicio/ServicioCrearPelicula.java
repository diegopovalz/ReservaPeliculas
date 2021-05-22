package com.ceiba.pelicula.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;

public class ServicioCrearPelicula {
	
	private static final String PELICULA_YA_EXISTE = "Ya existe una pelicula con el nombre ingresado";
	
	private final RepositorioPelicula repositorioPelicula;
	
	public ServicioCrearPelicula(RepositorioPelicula repositorioPelicula) {
		this.repositorioPelicula = repositorioPelicula;
	}
	
	public Long crear(Pelicula pelicula) {
		validarExiste(pelicula);
		return this.repositorioPelicula.crear(pelicula);
	}
	
	private void validarExiste(Pelicula pelicula) {
		boolean existe = this.repositorioPelicula.existe(pelicula.getNombre());
		if(existe) {
			throw new ExcepcionDuplicidad(PELICULA_YA_EXISTE);
		}
	}

}
