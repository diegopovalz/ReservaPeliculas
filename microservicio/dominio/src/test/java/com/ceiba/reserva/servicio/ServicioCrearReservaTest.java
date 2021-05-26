package com.ceiba.reserva.servicio;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionFormatoIncorrecto;
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
	public void validarReservaConFormatoIncorrectoTest() {
		//Arrange
		ReservaTestDataBuilder reserva = new ReservaTestDataBuilder().conFechaReserva("22/05/2021");
		
		//Act - Assert
		BasePrueba.assertThrows(() -> reserva.build(), ExcepcionFormatoIncorrecto.class, "La fecha ingresada no cumple el formato asignado");
	}
	
	@Test
	public void validarReservaConFechaReservaEnSabadoTest() {
		//Arrange
		ReservaTestDataBuilder reserva = new ReservaTestDataBuilder().conFechaReserva("22-05-2021");
		
		//Act - Assert
		BasePrueba.assertThrows(() -> reserva.build(), ExcepcionValorInvalido.class, "La reserva no puede ser realizada en fin de semana");
	}
	
	@Test
	public void validarReservaConFechaReservaEnDomingoTest() {
		//Arrange
		ReservaTestDataBuilder reserva = new ReservaTestDataBuilder().conFechaReserva("23-05-2021");
		
		//Act - Assert
		BasePrueba.assertThrows(() -> reserva.build(), ExcepcionValorInvalido.class, "La reserva no puede ser realizada en fin de semana");
	}
	
	@Test
	public void validarReservaConFechaReservaEnSemanaTest() {
		//Arrange
		ReservaTestDataBuilder reserva = new ReservaTestDataBuilder().conFechaReserva("24-05-2021");
		
		//Act - Assert
		assertDoesNotThrow(() -> reserva.build());
	}
	
	@Test
	public void validarReservaEstandarAplica6DiasTest() {
		//Arrange
		Reserva reserva = new ReservaTestDataBuilder().conFechaReserva("24-05-2021").build();
		
		//Act - Assert
		assertEquals(LocalDate.of(2021, 5, 31), reserva.getFechaDevolucion());
	}
	
	@Test
	public void validarReservaPremiumAplica10DiasTest() {
		//Arrange
		Reserva reserva = new ReservaTestDataBuilder().conTipoReserva("PREMIUM").conFechaReserva("19-05-2021").build();
		
		//Act - Assert
		assertEquals(LocalDate.of(2021, 5, 31), reserva.getFechaDevolucion());
	}
	
	@Test
    public void validarReservaPeliculaNoExisteTest() {
        // Arrange
		Reserva reserva = new ReservaTestDataBuilder().build();
        
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
        Mockito.when(repositorioPelicula.existe(Mockito.anyString())).thenReturn(false);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioPelicula);
        
        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.crear(reserva), ExcepcionNoExiste.class, "No existe ninguna pelicula con el nombre asignado");
    }
	
	@Test
    public void validarReservaPeliculaExisteTest() {
        // Arrange
		Reserva reserva = new ReservaTestDataBuilder().build();
        
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
        Mockito.when(repositorioPelicula.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioPelicula);
        
        // Act - Assert
        assertDoesNotThrow(() -> servicioCrearReserva.crear(reserva));
    }
	
	@Test
    public void validarReservaPeliculaNoReservadaTest() {
        // Arrange
		Reserva reserva = new ReservaTestDataBuilder().build();
        
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
        Mockito.when(repositorioPelicula.existe(Mockito.anyString())).thenReturn(true);
        Mockito.when(repositorioPelicula.estaReservada(Mockito.anyString())).thenReturn(false);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioPelicula);
        
        // Act - Assert
        assertDoesNotThrow(() -> servicioCrearReserva.crear(reserva));
    }
	
	@Test
    public void validarReservaPeliculaReservadaTest() {
        // Arrange
		Reserva reserva = new ReservaTestDataBuilder().build();
        
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
        Mockito.when(repositorioPelicula.existe(Mockito.anyString())).thenReturn(true);
        Mockito.when(repositorioPelicula.estaReservada(Mockito.anyString())).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioPelicula);
        
        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.crear(reserva), ExcepcionNoExiste.class, "No existe ninguna pelicula con el nombre asignado que no este reservada");
    }
}
