package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.modelo.entidad.TipoReserva;

public class ComandoReservaTestDataBuilder {

	private Long id;
	private String fechaReserva;
	private String tipoReserva;
	private String nombre;
	
	public ComandoReservaTestDataBuilder() {
		this.nombre = "Prueba";
		this.tipoReserva = "ESTANDAR";
		this.fechaReserva = "24-05-2021";
	}
	
	public ComandoReservaTestDataBuilder conTipoReserva(String tipoReserva) {
		this.tipoReserva = tipoReserva;
		return this;
	}
	
	public ComandoReservaTestDataBuilder conFechaReserva(String fechaReserva) {
		this.fechaReserva = fechaReserva;
		return this;
	}
	
	public ComandoReservaTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public ComandoReserva build() {
		return new ComandoReserva(id, TipoReserva.deNombre(tipoReserva), fechaReserva, nombre);
	}
}
