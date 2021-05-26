package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.pelicula.modelo.entidad.EstadoPelicula;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.modelo.entidad.TipoReserva;

public class ReservaTestDataBuilder {

	private Long id;
	private String fechaReserva;
	private String tipoReserva;
	private Pelicula pelicula;
	
	public ReservaTestDataBuilder() {
		this.fechaReserva = "25-05-2021";
		this.tipoReserva = "ESTANDAR";
		this.pelicula = new Pelicula(1L, "Prueba", "Autor", "Descripcion", EstadoPelicula.SIN_RESERVAR);
	}
	
	public ReservaTestDataBuilder conTipoReserva(String tipoReserva) {
		this.tipoReserva = tipoReserva;
		return this;
	}
	
	public ReservaTestDataBuilder conFechaReserva(String fechaReserva) {
		this.fechaReserva = fechaReserva;
		return this;
	}
	
	public Reserva build() {
		return new Reserva(id, fechaReserva, TipoReserva.deNombre(tipoReserva), pelicula);
	}
}
