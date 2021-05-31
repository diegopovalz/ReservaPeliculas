package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.pelicula.modelo.entidad.EstadoPelicula;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.modelo.entidad.TipoReserva;

public class ComandoReservaTestDataBuilder {

	private Long id;
	private String fechaReserva;
	private String tipoReserva;
	private Pelicula pelicula;
	
	public ComandoReservaTestDataBuilder() {
		this.tipoReserva = "ESTANDAR";
		this.fechaReserva = "24-05-2021";
		this.pelicula = new Pelicula(null, "Prueba", "Autor", "Descripcion", EstadoPelicula.SIN_RESERVAR);
	}
	
	public ComandoReservaTestDataBuilder conTipoReserva(String tipoReserva) {
		this.tipoReserva = tipoReserva;
		return this;
	}
	
	public ComandoReservaTestDataBuilder conFechaReserva(String fechaReserva) {
		this.fechaReserva = fechaReserva;
		return this;
	}
	
	public ComandoReservaTestDataBuilder conPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
		return this;
	}
	
	public ComandoReserva build() {
		return new ComandoReserva(id, TipoReserva.deNombre(tipoReserva), fechaReserva, pelicula);
	}
}
