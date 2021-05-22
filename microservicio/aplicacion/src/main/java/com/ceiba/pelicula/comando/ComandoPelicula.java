package com.ceiba.pelicula.comando;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPelicula {
	
	private Long id;
	private String nombre;
	private String autor;
	private String descripcion;
	private String estaReservado;
	
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
	public String getEstaReservado() {
		return estaReservado;
	}
}
