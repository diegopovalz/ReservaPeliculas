package com.ceiba.reserva.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.manejador.ManejadorCrearReserva;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
public class ComandoControladorReserva {

	private final ManejadorCrearReserva manejadorCrearReserva;
	
	@Autowired
	public ComandoControladorReserva(ManejadorCrearReserva manejadorCrearReserva) {
		this.manejadorCrearReserva = manejadorCrearReserva;
	}
	
	@PostMapping
	@ApiOperation("Crear reserva")
	public ComandoRespuesta<Long> crear(@RequestBody ComandoReserva comandoReserva) {
		return this.manejadorCrearReserva.ejecutar(comandoReserva);
	}
}
