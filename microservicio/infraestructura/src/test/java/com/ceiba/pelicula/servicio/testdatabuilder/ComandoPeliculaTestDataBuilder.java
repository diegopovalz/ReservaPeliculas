package com.ceiba.pelicula.servicio.testdatabuilder;

import com.ceiba.pelicula.comando.ComandoPelicula;

public class ComandoPeliculaTestDataBuilder {

	private Long id;
	private String nombre;
	private String autor;
	private String descripcion;
	
	public ComandoPeliculaTestDataBuilder() {
		this.nombre = "Pelicula";
		this.autor = "Autor2";
		this.descripcion = "Descripcion2";
	}
	
	public ComandoPeliculaTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}
	
	public ComandoPeliculaTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public ComandoPelicula build() {
		return new ComandoPelicula(id, nombre, autor, descripcion);
	}
}
