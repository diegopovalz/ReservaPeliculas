package com.ceiba.reserva.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.hamcrest.core.Is.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.ApplicationMock;
import com.ceiba.pelicula.modelo.entidad.EstadoPelicula;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.controlador.ComandoControladorReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ComandoReservaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorReserva.class)
public class ComandoControladorReservaTest {

	@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void debeCrearReservaEstandar() throws Exception {
    	// Arrange
    	ComandoReserva reserva = new ComandoReservaTestDataBuilder()
    			.conPelicula(
						new Pelicula(null, "Pelicula", "Autor", "Descripcion", EstadoPelicula.SIN_RESERVAR)
				).build();

        // Act - Assert
        mocMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reserva)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': '2021-05-31'}"));
    }
    
    @Test
    public void debeCrearReservaPremium() throws Exception {
    	// Arrange
    	ComandoReserva reserva = new ComandoReservaTestDataBuilder()
    			.conPelicula(
						new Pelicula(null, "Test1", "Autor", "Descripcion", EstadoPelicula.SIN_RESERVAR)
				).conTipoReserva("PREMIUM").build();

        // Act - Assert
        mocMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reserva)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': '2021-06-03'}"));
    }
    
    @Test
    public void debeTirarErrorCuandoPeliculaNoExiste() throws Exception {
    	// Arrange
    	ComandoReserva reserva = new ComandoReservaTestDataBuilder()
    			.conPelicula(
    					new Pelicula(null, "PruebaPelicula1", "Autor", "Descripcion", EstadoPelicula.SIN_RESERVAR)
    			).build();

        // Act - Assert
        mocMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reserva)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.mensaje", is("No existe ninguna pelicula con el nombre asignado")));
    }
    
    @Test
    public void debeTirarErrorCuandoPeliculaReservada() throws Exception {
    	// Arrange
    	ComandoReserva reserva = new ComandoReservaTestDataBuilder()
    			.conPelicula(
						new Pelicula(null, "Movie", "Autor", "Descripcion", EstadoPelicula.RESERVADA)
				).build();

        // Act - Assert
        mocMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reserva)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.mensaje", is("No existe ninguna pelicula con el nombre asignado que no este reservada")));
    }
}
