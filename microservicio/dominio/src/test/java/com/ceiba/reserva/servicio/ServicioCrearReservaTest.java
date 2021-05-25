package com.ceiba.reserva.servicio;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDate;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionNoExiste;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
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
	
	@Test
    public void validarReservaPeliculaNoReservadaTest() {
        // Arrange
		Reserva reserva = new ReservaTestDataBuilder().conTipoReserva("ESTANDAR").build();
        
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
        Mockito.when(repositorioPelicula.estaReservada(Mockito.anyLong())).thenReturn(false);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioPelicula);
        
        // Act - Assert
        assertDoesNotThrow(() -> servicioCrearReserva.crear(reserva));
    }
	
	@Test
    public void validarReservaPeliculaReservadaTest() {
        // Arrange
		Reserva reserva = new ReservaTestDataBuilder().conTipoReserva("ESTANDAR").build();
        
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
        Mockito.when(repositorioPelicula.estaReservada(Mockito.anyLong())).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioPelicula);
        
        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.crear(reserva), ExcepcionNoExiste.class, "No existe ninguna pelicula con el nombre asignado que no este reservada");
    }
	
	@Test
	public void validarReservaConFechaReservaEnSemanaTest() {
		//Arrange
		Reserva reserva = new ReservaTestDataBuilder().conTipoReserva("ESTANDAR").build();
		
		//Act - Assert
		assertTrue(reserva.getFechaReserva().getDayOfWeek() != DayOfWeek.SATURDAY && reserva.getFechaReserva().getDayOfWeek() != DayOfWeek.SUNDAY);
	}
	
	@Test
	public void validarReservaConFechaReservaEnFinDeSemanaTest() {
		// Arrange
		Reserva reserva = new ReservaTestDataBuilder().conFechaReserva(LocalDate.of(2021, 5, 22)).conTipoReserva("ESTANDAR").build();
        
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
        Mockito.when(repositorioPelicula.estaReservada(Mockito.anyLong())).thenReturn(false);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioPelicula);
		
        // Act - Assert
		BasePrueba.assertThrows(() -> servicioCrearReserva.crear(reserva), ExcepcionValorInvalido.class, "La reserva no puede ser realizada en fin de semana");
	}
}
