package com.ceiba.pelicula.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Pelicula {

	private static final String DEBE_INGRESAR_NOMBRE = "Debe ingresar un nombre de la pelicula";
	private static final String DEBE_INGRESAR_AUTOR = "Debe ingresar un autor de la pelicula";
	private static final String DEBE_INGRESAR_DESCRIPCION = "Debe ingresar una descripcion de la pelicula";
	private static final String DEBE_TENER_ESTADO = "La pelicula debe tener un estado";
	
	private Long id;
	private String nombre;
	private String autor;
	private String descripcion;
	private String estadoPelicula;
	
	public Pelicula(Long id, String nombre, String autor, String descripcion, EstadoPelicula estadoPelicula) {
		validarObligatorio(nombre, DEBE_INGRESAR_NOMBRE);
		validarObligatorio(autor, DEBE_INGRESAR_AUTOR);
		validarObligatorio(descripcion, DEBE_INGRESAR_DESCRIPCION);
		validarObligatorio(estadoPelicula, DEBE_TENER_ESTADO);
		
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.descripcion = descripcion;
		this.estadoPelicula = estadoPelicula.name();
	}
	
}
