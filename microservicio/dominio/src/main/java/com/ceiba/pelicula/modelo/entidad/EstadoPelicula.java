package com.ceiba.pelicula.modelo.entidad;

import java.util.stream.Stream;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

public enum EstadoPelicula {

	RESERVADA,
	SIN_RESERVAR;
	
	private EstadoPelicula() { }
	
	public static EstadoPelicula deNombre(String estado) {
		if(estado == null)
			return null;
		return Stream.of(EstadoPelicula.values())
				.filter(e -> e.name().equals(estado))
				.findFirst()
				.orElseThrow(() -> new ExcepcionValorInvalido(String.format("No existe el estado %s", estado)));
	}
}
