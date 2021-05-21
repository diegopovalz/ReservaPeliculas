package com.ceiba.pelicula.puerto.repositorio;

import com.ceiba.pelicula.modelo.entidad.Pelicula;

public interface RepositorioPelicula {
	boolean existe(String name);
	
	Long crear(Pelicula pelicula);
}
