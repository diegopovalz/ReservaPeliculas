package com.ceiba.pelicula.modelo.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DtoPelicula {
	private Long id;
	private String nombre;
	private String autor;
	private String descripcion;
	
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getAutor() {
		return autor;
	}
	public String getDescripcion() {
		return descripcion;
	}
}
