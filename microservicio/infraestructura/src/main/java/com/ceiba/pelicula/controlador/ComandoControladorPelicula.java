package com.ceiba.pelicula.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.pelicula.comando.ComandoPelicula;
import com.ceiba.pelicula.comando.manejador.ManejadorCrearPelicula;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/peliculas")
@Api(tags = {"Controlador comando pelicula"})
public class ComandoControladorPelicula {
	
	private final ManejadorCrearPelicula manejadorCrearPelicula;
	
	@Autowired
	public ComandoControladorPelicula(ManejadorCrearPelicula manejadorCrearPelicula) {
		this.manejadorCrearPelicula = manejadorCrearPelicula;
	}
	
	@PostMapping("/pelicula")
	@ApiOperation("Crear pelicula")
	public ComandoRespuesta<Long> crear(@RequestBody ComandoPelicula comandoPelicula) {
		return this.manejadorCrearPelicula.ejecutar(comandoPelicula);
	}
}
