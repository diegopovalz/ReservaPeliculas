package com.ceiba.pelicula.testdatabuilder;

import com.ceiba.pelicula.modelo.entidad.Pelicula;

public class PeliculaTestDataBuilder {

	private Long id;
	private String nombre;
	private String autor;
	private String descripcion;
	private String estaReservado;
	
	public PeliculaTestDataBuilder() {
		this.nombre = "Prueba";
		this.autor = "Autor";
		this.descripcion = "Descripcion";
		this.estaReservado = "F";
	}
	
	public PeliculaTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}
	
	public PeliculaTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public PeliculaTestDataBuilder conAutor(String autor) {
		this.autor = autor;
		return this;
	}
	
	public PeliculaTestDataBuilder conDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}
	
	public Pelicula build() {
		return new Pelicula(id, nombre, autor, descripcion, estaReservado);
	}
}
