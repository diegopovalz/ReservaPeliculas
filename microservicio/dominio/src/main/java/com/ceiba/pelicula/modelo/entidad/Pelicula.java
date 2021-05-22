package com.ceiba.pelicula.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Pelicula {

	private static final String DEBE_INGRESAR_NOMBRE = "Debe ingresar un nombre de la pelicula";
	private static final String DEBE_INGRESAR_AUTOR = "Debe ingresar un autor de la pelicula";
	private static final String DEBE_INGRESAR_DESCRIPCION = "Debe ingresar una descripcion de la pelicula";
	
	private Long id;
	private String nombre;
	private String autor;
	private String descripcion;
	private String estaReservado;
	
	public Pelicula(Long id, String nombre, String autor, String descripcion, String estaReservado) {
		validarObligatorio(nombre, DEBE_INGRESAR_NOMBRE);
		validarObligatorio(autor, DEBE_INGRESAR_AUTOR);
		validarObligatorio(descripcion, DEBE_INGRESAR_DESCRIPCION);
		
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.descripcion = descripcion;
		this.estaReservado = estaReservado;
	}

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
