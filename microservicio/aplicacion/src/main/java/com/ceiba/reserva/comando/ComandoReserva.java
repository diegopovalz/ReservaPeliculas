package com.ceiba.reserva.comando;

import com.ceiba.reserva.modelo.entidad.TipoReserva;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ComandoReserva {
	
	private Long id;
	private Double valor;
	private String fechaReserva;
	private String fechaDevolucion;
	private TipoReserva tipoReserva;
	private String nombre;
}
