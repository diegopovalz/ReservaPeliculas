package com.ceiba.pelicula.consulta;

import java.util.List;

import com.ceiba.pelicula.modelo.dto.DtoPelicula;
import com.ceiba.pelicula.puerto.dao.DaoPelicula;

public class ManejadorListarPeliculas {

	private final DaoPelicula daoPelicula;
	
	public ManejadorListarPeliculas(DaoPelicula daoPelicula) {
		this.daoPelicula = daoPelicula;
	}
	
	public List<DtoPelicula> ejecutar() {
		return this.daoPelicula.listar();
	}
}
