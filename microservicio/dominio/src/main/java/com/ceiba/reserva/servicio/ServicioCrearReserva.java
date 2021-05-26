package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionNoExiste;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioCrearReserva {

	private static final String PELICULA_CON_NOMBRE_SIN_RESERVAR_NO_EXISTE = "No existe ninguna pelicula con el nombre asignado que no este reservada";
	private static final String PELICULA_CON_NOMBRE_NO_EXISTE = "No existe ninguna pelicula con el nombre asignado";
	
	private final RepositorioReserva repositorioReserva;
	private final RepositorioPelicula repositorioPelicula;
	
	public ServicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioPelicula repositorioPelicula) {
		this.repositorioReserva = repositorioReserva;
		this.repositorioPelicula = repositorioPelicula;
	}
	
	public Long crear(Reserva reserva) {
		validarPeliculaExiste(reserva.getPelicula().getNombre());
		validarPeliculaNoReservada(reserva.getPelicula().getNombre());
		return this.repositorioReserva.crear(reserva);
	}
	
	private void validarPeliculaExiste(String nombre) {
		boolean existe = this.repositorioPelicula.existe(nombre);
		if(!existe) {
			throw new ExcepcionNoExiste(PELICULA_CON_NOMBRE_NO_EXISTE);
		}
	}
	
	private void validarPeliculaNoReservada(String nombre) {
		boolean reservada = this.repositorioPelicula.estaReservada(nombre);
		if(reservada) {
			throw new ExcepcionNoExiste(PELICULA_CON_NOMBRE_SIN_RESERVAR_NO_EXISTE);
		}
	}
}
