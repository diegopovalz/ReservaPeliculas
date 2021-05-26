package com.ceiba.pelicula.puerto.dao;

import java.util.List;

import com.ceiba.pelicula.modelo.dto.DtoPelicula;

public interface DaoPelicula {

	List<DtoPelicula> listar();
	DtoPelicula encontrar(String name);
}
