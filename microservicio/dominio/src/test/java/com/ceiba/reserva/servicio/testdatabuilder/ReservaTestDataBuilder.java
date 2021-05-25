package com.ceiba.reserva.servicio.testdatabuilder;

import java.time.LocalDate;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.modelo.entidad.TipoReserva;

public class ReservaTestDataBuilder {

	private Long id;
	private LocalDate fechaReserva;
	private LocalDate fechaDevolucion;
	private String tipoReserva;
	private Long peliculaId;
	
	public ReservaTestDataBuilder() {
		this.fechaDevolucion = LocalDate.now();
		this.fechaReserva = LocalDate.of(2021, 5, 25);
		this.peliculaId = 1L;
	}
	
	public ReservaTestDataBuilder conTipoReserva(String tipoReserva) {
		this.tipoReserva = tipoReserva;
		return this;
	}
	
	public ReservaTestDataBuilder conFechaReserva(LocalDate fechaReserva) {
		this.fechaReserva = fechaReserva;
		return this;
	}
	
	public ReservaTestDataBuilder conFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
		return this;
	}
	
	public Reserva build() {
		return new Reserva(id, fechaReserva, fechaDevolucion, TipoReserva.deNombre(tipoReserva), peliculaId);
	}
}
