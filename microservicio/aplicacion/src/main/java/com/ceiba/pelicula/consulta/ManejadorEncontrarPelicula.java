package com.ceiba.pelicula.consulta;

import com.ceiba.pelicula.modelo.dto.DtoPelicula;
import com.ceiba.pelicula.puerto.dao.DaoPelicula;

public class ManejadorEncontrarPelicula {

	private final DaoPelicula daoPelicula;
	
	public ManejadorEncontrarPelicula(DaoPelicula daoPelicula) {
		this.daoPelicula = daoPelicula;
	}
	
	public DtoPelicula encontrar(String nombre) {
		return this.daoPelicula.encontrar(nombre);
	}
}
