package com.ceiba.pelicula.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.pelicula.consulta.ManejadorEncontrarPelicula;
import com.ceiba.pelicula.consulta.ManejadorListarPeliculas;
import com.ceiba.pelicula.modelo.dto.DtoPelicula;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/peliculas")
@Api(tags = {"Controlador consulta peliculas"})
public class ConsultaControladorPelicula {
	
	private final ManejadorListarPeliculas manejadorListarPeliculas;
	private final ManejadorEncontrarPelicula manejadorEncontrarPelicula;
	
	public ConsultaControladorPelicula(ManejadorListarPeliculas manejadorListarPeliculas, ManejadorEncontrarPelicula manejadorEncontrarPelicula) {
		this.manejadorListarPeliculas = manejadorListarPeliculas;
		this.manejadorEncontrarPelicula = manejadorEncontrarPelicula;
	}
	
	@GetMapping("")
	@ApiOperation("Listar peliculas")
	public List<DtoPelicula> listar() {
		return this.manejadorListarPeliculas.ejecutar();
	}
	
	@GetMapping("/{nombre}")
	@ApiOperation("Encontrar pelicula")
	public DtoPelicula encontrar(@PathVariable("nombre") String nombre) {
		return this.manejadorEncontrarPelicula.encontrar(nombre);
	}

}
