package com.ceiba.pelicula.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ceiba.reserva.modelo.entidad.Reserva;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "peliculas")
public class Pelicula {

	private static final String DEBE_INGRESAR_NOMBRE = "";
	private static final String DEBE_INGRESAR_AUTOR = "";
	private static final String DEBE_INGRESAR_DESCRIPCION = "";
	
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private String autor;
	private String descripcion;
	private boolean estaReservado;
	
	@OneToOne(mappedBy = "peliculas")
	private Reserva reserva;
	
	public Pelicula(Long id, String nombre, String autor, String descripcion, boolean estaReservado) {
		validarObligatorio(nombre, DEBE_INGRESAR_NOMBRE);
		validarObligatorio(autor, DEBE_INGRESAR_AUTOR);
		validarObligatorio(descripcion, DEBE_INGRESAR_DESCRIPCION);
		
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.descripcion = descripcion;
		this.estaReservado = estaReservado;
	}
}
