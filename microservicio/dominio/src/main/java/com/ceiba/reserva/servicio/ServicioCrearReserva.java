package com.ceiba.reserva.servicio;

import java.time.DayOfWeek;
import java.time.LocalDate;

import com.ceiba.dominio.excepcion.ExcepcionNoExiste;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioCrearReserva {

	private static final String PELICULA_CON_NOMBRE_SIN_RESERVAR_NO_EXISTE = "No existe ninguna pelicula con el nombre asignado que no este reservada";
	private static final String RESERVA_NO_EN_FIN_DE_SEMANA = "La reserva no puede ser realizada en fin de semana";
	
	private final RepositorioReserva repositorioReserva;
	private final RepositorioPelicula repositorioPelicula;
	
	public ServicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioPelicula repositorioPelicula) {
		this.repositorioReserva = repositorioReserva;
		this.repositorioPelicula = repositorioPelicula;
	}
	
	public Long crear(Reserva reserva) {
		validarFechaEnSemana(reserva.getFechaReserva());
		validarPeliculaNoReservada(reserva.getPeliculaId());
		return this.repositorioReserva.crear(reserva);
	}
	
	private void validarPeliculaNoReservada(Long id) {
		boolean reservada = this.repositorioPelicula.estaReservada(id);
		if(reservada) {
			throw new ExcepcionNoExiste(PELICULA_CON_NOMBRE_SIN_RESERVAR_NO_EXISTE);
		}
	}
	
	private void validarFechaEnSemana(LocalDate fecha) {
		boolean esFinDeSemana = fecha.getDayOfWeek() == DayOfWeek.SATURDAY || fecha.getDayOfWeek() == DayOfWeek.SUNDAY;
		if(esFinDeSemana) {
			throw new ExcepcionValorInvalido(RESERVA_NO_EN_FIN_DE_SEMANA);
		}
	}
}
