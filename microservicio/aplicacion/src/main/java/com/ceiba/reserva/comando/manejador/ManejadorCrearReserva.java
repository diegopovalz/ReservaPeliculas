package com.ceiba.reserva.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.fabrica.FabricaReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.ServicioCrearReserva;
import com.ceiba.utiles.FechaUtiles;

@Component
public class ManejadorCrearReserva implements ManejadorComandoRespuesta<ComandoReserva, ComandoRespuesta<String>> {

	private final FabricaReserva fabricaReserva;
	private final ServicioCrearReserva servicioCrearReserva;
	
	public ManejadorCrearReserva(FabricaReserva fabricaReserva, ServicioCrearReserva servicioCrearReserva) {
		this.fabricaReserva = fabricaReserva;
		this.servicioCrearReserva = servicioCrearReserva;
	}
	
	public ComandoRespuesta<String> ejecutar(ComandoReserva comandoReserva) {
		Reserva reserva = this.fabricaReserva.crear(comandoReserva);
		this.servicioCrearReserva.crear(reserva);
		String fechaDevolucion = FechaUtiles.convertirFechaAString(reserva.getFechaDevolucion(), "dd-MM-yyyy");
		return new ComandoRespuesta<>(fechaDevolucion);
	}

}
