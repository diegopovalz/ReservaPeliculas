package com.ceiba.pelicula.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPelicula {
	private Long id;
	private String nombre;
	private String autor;
	private String descripcion;
	
}
