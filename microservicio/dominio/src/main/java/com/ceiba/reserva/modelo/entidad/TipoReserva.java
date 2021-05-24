package com.ceiba.reserva.modelo.entidad;

import java.util.stream.Stream;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

public enum TipoReserva {
	//NOMBRE(Valor, Dias reserva)
	ESTANDAR(20d, 6),
	PREMIUM(50d, 10);
	
	private Double valorReserva;
	private int diasReserva;
	
	private TipoReserva(Double valorReserva, int diasReserva) {
		this.valorReserva = valorReserva;
		this.diasReserva = diasReserva;
	}
	
	public Double getValorReserva() {
		return this.valorReserva;
	}
	
	public int getDiasReserva() {
		return this.diasReserva;
	}
	
	public static TipoReserva deNombre(String nombreTipo) {
		if(nombreTipo == null) {
			return null;
		}
		return Stream.of(TipoReserva.values())
				.filter(t -> t.name().equals(nombreTipo))
				.findFirst()
				.orElseThrow(() -> new ExcepcionValorInvalido(String.format("No existe el tipo de reserva %s", nombreTipo)));
	}
}
