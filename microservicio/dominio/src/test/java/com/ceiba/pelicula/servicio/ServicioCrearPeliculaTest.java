package com.ceiba.pelicula.servicio;

import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import com.ceiba.pelicula.servicio.testdatabuilder.PeliculaTestDataBuilder;

public class ServicioCrearPeliculaTest {

	@Test
	public void validarPeliculaConNombreTest() {
		//Arrange
		PeliculaTestDataBuilder pelicula = new PeliculaTestDataBuilder().conNombre(null);
		
		//Act - Assert
		BasePrueba.assertThrows(() -> pelicula.build(), ExcepcionValorObligatorio.class, "Debe ingresar un nombre de la pelicula");
	}
	
	@Test
	public void validarPeliculaConNombreMenorA5Test() {
		//Arrange
		PeliculaTestDataBuilder pelicula = new PeliculaTestDataBuilder().conNombre("T");
		
		//Act - Assert
		BasePrueba.assertThrows(() -> pelicula.build(), ExcepcionLongitudValor.class, "El nombre de la pelicula debe tener una longitud mayor a 5 caracteres y menor a 30 caracteres");
	}
	
	@Test
	public void validarPeliculaConNombreMayorA30Test() {
		//Arrange
		PeliculaTestDataBuilder pelicula = new PeliculaTestDataBuilder().conNombre("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		
		//Act - Assert
		BasePrueba.assertThrows(() -> pelicula.build(), ExcepcionLongitudValor.class, "El nombre de la pelicula debe tener una longitud mayor a 5 caracteres y menor a 30 caracteres");
	}
	
	@Test
	public void validarPeliculaConAutorTest() {
		//Arrange
		PeliculaTestDataBuilder pelicula = new PeliculaTestDataBuilder().conAutor(null);
		
		//Act - Assert
		BasePrueba.assertThrows(() -> pelicula.build(), ExcepcionValorObligatorio.class, "Debe ingresar un autor de la pelicula");
	}
	
	@Test
	public void validarPeliculaConAutorMenorA5Test() {
		//Arrange
		PeliculaTestDataBuilder pelicula = new PeliculaTestDataBuilder().conAutor("T");
		
		//Act - Assert
		BasePrueba.assertThrows(() -> pelicula.build(), ExcepcionLongitudValor.class, "El autor de la pelicula debe tener una longitud mayor a 5 caracteres y menor a 30 caracteres");
	}
	
	@Test
	public void validarPeliculaConAutorMayorA30Test() {
		//Arrange
		PeliculaTestDataBuilder pelicula = new PeliculaTestDataBuilder().conAutor("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		
		//Act - Assert
		BasePrueba.assertThrows(() -> pelicula.build(), ExcepcionLongitudValor.class, "El autor de la pelicula debe tener una longitud mayor a 5 caracteres y menor a 30 caracteres");
	}
	
	@Test
	public void validarPeliculaConDescripcionTest() {
		//Arrange
		PeliculaTestDataBuilder pelicula = new PeliculaTestDataBuilder().conDescripcion(null);
		
		//Act - Assert
		BasePrueba.assertThrows(() -> pelicula.build(), ExcepcionValorObligatorio.class, "Debe ingresar una descripcion de la pelicula");
	}
	
	@Test
	public void validarPeliculaConDescripcionMenorA5Test() {
		//Arrange
		PeliculaTestDataBuilder pelicula = new PeliculaTestDataBuilder().conDescripcion("T");
		
		//Act - Assert
		BasePrueba.assertThrows(() -> pelicula.build(), ExcepcionLongitudValor.class, "La descripcion de la pelicula debe tener una longitud mayor a 5 caracteres y menor a 40 caracteres");
	}
	
	@Test
	public void validarPeliculaConDescripcionMayorA40Test() {
		//Arrange
		PeliculaTestDataBuilder pelicula = new PeliculaTestDataBuilder().conDescripcion("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		
		//Act - Assert
		BasePrueba.assertThrows(() -> pelicula.build(), ExcepcionLongitudValor.class, "La descripcion de la pelicula debe tener una longitud mayor a 5 caracteres y menor a 40 caracteres");
	}
	
	@Test
	public void validarPeliculaSinEstadoTest() {
		//Arrange
		PeliculaTestDataBuilder pelicula = new PeliculaTestDataBuilder().conEstado(null);
		
		//Act - Assert
		BasePrueba.assertThrows(() -> pelicula.build(), ExcepcionValorObligatorio.class, "La pelicula debe tener un estado");
	}
	
	@Test
	public void validarPeliculaConEstadoNoValidoTest() {
		//Arrange
		PeliculaTestDataBuilder pelicula = new PeliculaTestDataBuilder().conEstado("PRUEBA");
		
		//Act - Assert
		BasePrueba.assertThrows(() -> pelicula.build(), ExcepcionValorInvalido.class, "No existe el estado PRUEBA");
	}
	
	@Test
	public void validarPeliculaConEstadoSinReservarValidoTest() {
		//Arrange
		PeliculaTestDataBuilder pelicula = new PeliculaTestDataBuilder().conEstado("SIN_RESERVAR");
		
		//Act - Assert
		assertDoesNotThrow(() -> pelicula.build());
	}
	
	@Test
	public void validarPeliculaConEstadoReservadaValidoTest() {
		//Arrange
		PeliculaTestDataBuilder pelicula = new PeliculaTestDataBuilder().conEstado("RESERVADA");
		
		//Act - Assert
		assertDoesNotThrow(() -> pelicula.build());
	}
	
	@Test
    public void validarPeliculaYaExisteTest() {
        // Arrange
        Pelicula pelicula = new PeliculaTestDataBuilder().build();
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
        Mockito.when(repositorioPelicula.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearPelicula servicioCrearPelicula = new ServicioCrearPelicula(repositorioPelicula);
        
        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearPelicula.crear(pelicula), ExcepcionDuplicidad.class, "Ya existe una pelicula con el nombre ingresado");
    }
	
	@Test
    public void validarPeliculaNuevaQueNoExisteNoTiraExcepcionTest() {
        // Arrange
        Pelicula pelicula = new PeliculaTestDataBuilder().conNombre("PeliculaPrueba1").build();
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
        Mockito.when(repositorioPelicula.existe(Mockito.anyString())).thenReturn(false);
        ServicioCrearPelicula servicioCrearPelicula = new ServicioCrearPelicula(repositorioPelicula);
        
        // Act - Assert
        assertDoesNotThrow(() -> servicioCrearPelicula.crear(pelicula));
    }
}
