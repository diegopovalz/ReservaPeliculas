package com.ceiba.pelicula.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.pelicula.comando.ComandoPelicula;
import com.ceiba.pelicula.modelo.entidad.EstadoPelicula;
import com.ceiba.pelicula.modelo.entidad.Pelicula;

@Component
public class FabricaPelicula {

	public Pelicula crear(ComandoPelicula pelicula) {
		return new Pelicula(
				pelicula.getId(), 
				pelicula.getNombre(), 
				pelicula.getAutor(), 
				pelicula.getDescripcion(), 
				EstadoPelicula.SIN_RESERVAR
		);
	}
}
