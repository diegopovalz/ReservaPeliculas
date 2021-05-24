package com.ceiba.pelicula.puerto.repositorio;

import com.ceiba.pelicula.modelo.entidad.Pelicula;

public interface RepositorioPelicula {
	boolean existe(String name);
	boolean estaReservada(String nombre);
	
	Long crear(Pelicula pelicula);
}
