package com.ceiba.reserva.comando;

import com.ceiba.reserva.modelo.entidad.TipoReserva;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComandoReserva {
	
	private Long id;
	private Double valor;
	private String fechaReserva;
	private String fechaDevolucion;
	private TipoReserva tipoReserva;
	private String nombre;
	
	public Long getId() {
		return id;
	}
	public Double getValor() {
		return valor;
	}
	public String getFechaReserva() {
		return fechaReserva;
	}
	public String getFechaDevolucion() {
		return fechaDevolucion;
	}
	public TipoReserva getTipoReserva() {
		return tipoReserva;
	}
	public String getNombre() {
		return nombre;
	}
}
