package com.ceiba.pelicula.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.ApplicationMock;
import com.ceiba.pelicula.comando.ComandoPelicula;
import com.ceiba.pelicula.controlador.ComandoControladorPelicula;
import com.ceiba.pelicula.servicio.testdatabuilder.ComandoPeliculaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorPelicula.class)
public class ComandoControladorPeliculaTest {
	
	@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    
    @Test
    public void debeCrearUnaPelicula() throws Exception {
    	// Arrange
    	ComandoPelicula pelicula = new ComandoPeliculaTestDataBuilder().build();

        // Act - Assert
        mocMvc.perform(post("/peliculas/pelicula")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pelicula)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));
    }
    
    @Test
    public void debeTirarErrorSiExistePeliculaConMismoNombre() throws Exception {
    	// Arrange
    	ComandoPelicula pelicula = new ComandoPeliculaTestDataBuilder().conNombre("Prueba").build();

        // Act - Assert
        mocMvc.perform(post("/peliculas/pelicula")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pelicula)))
                .andExpect(status().isBadRequest());
    }
}
