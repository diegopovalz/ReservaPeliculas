package com.ceiba.pelicula.adaptador.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ceiba.pelicula.modelo.dto.DtoPelicula;
import com.ceiba.pelicula.modelo.entidad.Pelicula;

@Component
public class MapeadorPelicula {

	public DtoPelicula entidadADto(Pelicula pelicula) {
		return new DtoPelicula(pelicula.getId(),
				pelicula.getNombre(),
				pelicula.getAutor(),
				pelicula.getDescripcion()
		);
	}
	
	public List<DtoPelicula> listaEntidadesAListaDto(List<Pelicula> peliculas) {
		return peliculas
				.stream()
				.map(p -> entidadADto(p))
				.collect(Collectors.toList());
	}
}
