package com.ceiba.pelicula.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarLongitudMinima;
import static com.ceiba.dominio.ValidadorArgumento.validarLongitudMaxima;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Pelicula {

	private static final String DEBE_INGRESAR_NOMBRE = "Debe ingresar un nombre de la pelicula";
	private static final String DEBE_INGRESAR_AUTOR = "Debe ingresar un autor de la pelicula";
	private static final String DEBE_INGRESAR_DESCRIPCION = "Debe ingresar una descripcion de la pelicula";
	private static final String DEBE_TENER_ESTADO = "La pelicula debe tener un estado";
	private static final String NOMBRE_LONGITUD = "El nombre de la pelicula debe tener una longitud mayor a 5 caracteres y menor a 30 caracteres";
	private static final String AUTOR_LONGITUD = "El autor de la pelicula debe tener una longitud mayor a 5 caracteres y menor a 30 caracteres";
	private static final String DESCRIPCION_LONGITUD = "La descripcion de la pelicula debe tener una longitud mayor a 5 caracteres y menor a 40 caracteres";
	
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
		
		validarLongitudMinima(nombre, 5, NOMBRE_LONGITUD);
		validarLongitudMaxima(nombre, 30, NOMBRE_LONGITUD);
		validarLongitudMinima(autor, 5, AUTOR_LONGITUD);
		validarLongitudMaxima(autor, 30, AUTOR_LONGITUD);
		validarLongitudMinima(descripcion, 5, DESCRIPCION_LONGITUD);
		validarLongitudMaxima(descripcion, 40, DESCRIPCION_LONGITUD);
		
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.descripcion = descripcion;
		this.estadoPelicula = estadoPelicula.name();
	}
	
}
