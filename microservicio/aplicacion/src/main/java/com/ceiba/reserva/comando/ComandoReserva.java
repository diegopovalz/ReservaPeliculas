package com.ceiba.reserva.comando;

import com.ceiba.reserva.modelo.entidad.TipoReserva;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ComandoReserva {
	
	private Long id;
	private TipoReserva tipoReserva;
	private String fechaReserva;
	private String fechaDevolucion;
	private String nombre;
}
