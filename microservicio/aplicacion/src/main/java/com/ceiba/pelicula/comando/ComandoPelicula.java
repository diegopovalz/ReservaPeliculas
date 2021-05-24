package com.ceiba.pelicula.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ComandoPelicula {
	
	private Long id;
	private String nombre;
	private String autor;
	private String descripcion;
	private String estaReservado;
	
}
