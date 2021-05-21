package com.ceiba.reserva.comando;

import java.util.Date;

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
	private Date fechaReserva;
	private Date fechaDevolucion;
	private TipoReserva tipoReserva;
}
