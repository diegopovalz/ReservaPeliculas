package com.ceiba.pelicula.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pelicula.comando.ComandoPelicula;
import com.ceiba.pelicula.comando.fabrica.FabricaPelicula;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.servicio.ServicioCrearPelicula;

@Component
public class ManejadorCrearPelicula implements ManejadorComandoRespuesta<ComandoPelicula, ComandoRespuesta<Long>> {
	
	private final FabricaPelicula fabricaPelicula;
	private final ServicioCrearPelicula servicioCrearPelicula;
	
	public ManejadorCrearPelicula(FabricaPelicula fabricaPelicula, ServicioCrearPelicula servicioCrearPelicula) {
		this.fabricaPelicula = fabricaPelicula;
		this.servicioCrearPelicula = servicioCrearPelicula;
	}

	@Override
	public ComandoRespuesta<Long> ejecutar(ComandoPelicula comandoPelicula) {
		Pelicula pelicula = this.fabricaPelicula.crear(comandoPelicula);
		return new ComandoRespuesta<>(this.servicioCrearPelicula.crear(pelicula));
	}

}
