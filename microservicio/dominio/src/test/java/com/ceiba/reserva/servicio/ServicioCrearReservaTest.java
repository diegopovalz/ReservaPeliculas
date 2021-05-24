package com.ceiba.reserva.servicio;

import org.junit.Assert;
import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;

public class ServicioCrearReservaTest {
	
	@Test
	public void validarReservaConTipoTest() {
		//Arrange
		ReservaTestDataBuilder reserva = new ReservaTestDataBuilder().conTipoReserva(null);
		
		//Act - Assert
		BasePrueba.assertThrows(() -> reserva.build(), ExcepcionValorObligatorio.class, "Debe ingresar un tipo de reserva");
	}
	
	@Test
	public void validarReservaConTipoNoValidoTest() {
		//Arrange
		ReservaTestDataBuilder reserva = new ReservaTestDataBuilder().conTipoReserva("PRUEBA");
		
		//Act - Assert
		BasePrueba.assertThrows(() -> reserva.build(), ExcepcionValorInvalido.class, "No existe el tipo de reserva PRUEBA");
	}
	
	@Test
	public void validarReservaConTipoEstandarCuesta20Test() {
		ReservaTestDataBuilder reserva = new ReservaTestDataBuilder().conTipoReserva("ESTANDAR");
		
		Assert.assertEquals((Double) 20d, reserva.build().getValor());
	}
	
	@Test
	public void validarReservaConTipoPremiumCuesta50Test() {
		ReservaTestDataBuilder reserva = new ReservaTestDataBuilder().conTipoReserva("PREMIUM");
		
		Assert.assertEquals((Double) 50d, reserva.build().getValor());
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
