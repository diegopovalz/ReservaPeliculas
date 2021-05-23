package com.ceiba.reserva.servicio;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.reserva.testdatabuilder.ReservaTestDataBuilder;

public class ServicioCrearReservaTest {
	
	@Test
	public void validarReservaConTipoTest() {
		//Arrange
		ReservaTestDataBuilder reserva = new ReservaTestDataBuilder().conTipoReserva(null);
		
		//Act - Assert
		BasePrueba.assertThrows(() -> reserva.build(), ExcepcionValorObligatorio.class, "Debe ingresar un tipo de reserva");
	}
	
	@Test
	public void validarReservaConFechaReservaTest() {
		//Arrange
		ReservaTestDataBuilder reserva = new ReservaTestDataBuilder().conFechaReserva(null);
		
		//Act - Assert
		BasePrueba.assertThrows(() -> reserva.build(), ExcepcionValorObligatorio.class, "Debe ingresar una fecha de reserva");
	}
	
	@Test
	public void validarReservaConFechaDevolucionTest() {
		//Arrange
		ReservaTestDataBuilder reserva = new ReservaTestDataBuilder().conFechaDevolucion(null);
		
		//Act - Assert
		BasePrueba.assertThrows(() -> reserva.build(), ExcepcionValorObligatorio.class, "Debe ingresar una fecha de devolucion");
	}
}
