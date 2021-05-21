package com.ceiba.pelicula.adaptador.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.pelicula.adaptador.repositorio.RepositorioPeliculaJPA;
import com.ceiba.pelicula.modelo.dto.DtoPelicula;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.puerto.dao.DaoPelicula;

@Component
public class DaoPeliculaImpl implements DaoPelicula {

	private final RepositorioPeliculaJPA repositorio;
	private final MapeadorPelicula mapeadorPelicula;
	
	public DaoPeliculaImpl(RepositorioPeliculaJPA repositorioPeliculaJPA, MapeadorPelicula mapeadorPelicula) {
		this.repositorio = repositorioPeliculaJPA;
		this.mapeadorPelicula = mapeadorPelicula;
	}
	
	@Override
	public List<DtoPelicula> listar() {
		List<Pelicula> peliculas = this.repositorio.findAll();
		return mapeadorPelicula.listaEntidadesAListaDto(peliculas);
	}

	@Override
	public DtoPelicula encontrar(String nombre) {
		Pelicula pelicula = this.repositorio.findByNombre(nombre);
		return mapeadorPelicula.entidadADto(pelicula);
	}

}
