package com.ceiba.pelicula.servicio.testdatabuilder;

import com.ceiba.pelicula.modelo.entidad.EstadoPelicula;
import com.ceiba.pelicula.modelo.entidad.Pelicula;

public class PeliculaTestDataBuilder {

	private Long id;
	private String nombre;
	private String autor;
	private String descripcion;
	private String estadoPelicula;
	
	public PeliculaTestDataBuilder() {
		this.nombre = "Prueba";
		this.autor = "Autor";
		this.descripcion = "Descripcion";
		this.estadoPelicula = "SIN_RESERVAR";
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
	
	public PeliculaTestDataBuilder conEstado(String estadoPelicula) {
		this.estadoPelicula = estadoPelicula;
		return this;
	}
	
	public Pelicula build() {
		return new Pelicula(id, nombre, autor, descripcion, EstadoPelicula.deNombre(estadoPelicula));
	}
}
