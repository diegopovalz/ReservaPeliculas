package com.ceiba.reserva.modelo.entidad;

import java.util.stream.Stream;

public enum TipoReserva {

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
		return Stream.of(TipoReserva.values())
				.filter(t -> t.name().equals(nombreTipo))
				.findFirst()
				.orElse(null);
	}
}
