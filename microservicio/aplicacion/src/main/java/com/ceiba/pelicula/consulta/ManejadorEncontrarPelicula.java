package com.ceiba.pelicula.consulta;

import org.springframework.stereotype.Component;

import com.ceiba.dominio.excepcion.ExcepcionNoExiste;
import com.ceiba.pelicula.modelo.dto.DtoPelicula;
import com.ceiba.pelicula.puerto.dao.DaoPelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;

@Component
public class ManejadorEncontrarPelicula {
	
	private static final String PELICULA_CON_NOMBRE_NO_EXISTE = "No existe ninguna pelicula con el nombre ingresado";

	private final DaoPelicula daoPelicula;
	private final RepositorioPelicula repositorioPelicula;
	
	public ManejadorEncontrarPelicula(DaoPelicula daoPelicula, RepositorioPelicula repositorioPelicula) {
		this.daoPelicula = daoPelicula;
		this.repositorioPelicula = repositorioPelicula;
	}
	
	public DtoPelicula encontrar(String nombre) {
		boolean existe = this.repositorioPelicula.existe(nombre);
		if(!existe) {
			throw new ExcepcionNoExiste(PELICULA_CON_NOMBRE_NO_EXISTE);
		}
		return this.daoPelicula.encontrar(nombre);
	}
}
