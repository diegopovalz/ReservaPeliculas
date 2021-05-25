package com.ceiba.pelicula.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPelicula {
	
	private Long id;
	private String nombre;
	private String autor;
	private String descripcion;
	private String estaReservada;
	
}
