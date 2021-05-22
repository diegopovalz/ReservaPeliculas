package com.ceiba.pelicula.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPelicula {
	
	private Long id;
	private String nombre;
	private String autor;
	private String descripcion;
	private String estaReservado;
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setEstaReservado(String estaReservado) {
		this.estaReservado = estaReservado;
	}
	
}
