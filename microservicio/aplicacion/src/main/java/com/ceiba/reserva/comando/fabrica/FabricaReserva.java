package com.ceiba.reserva.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;

@Component
public class FabricaReserva {

	public Reserva crear(ComandoReserva reserva) {
		return new Reserva(
				reserva.getId(), 
				reserva.getValor(), 
				reserva.getFechaReserva(), 
				reserva.getFechaDevolucion(), 
				reserva.getTipoReserva()
		);
	}
}
