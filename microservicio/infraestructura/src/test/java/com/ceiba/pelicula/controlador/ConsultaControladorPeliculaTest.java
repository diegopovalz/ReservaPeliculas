package com.ceiba.pelicula.controlador;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import com.ceiba.pelicula.controlador.ConsultaControladorPelicula;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorPelicula.class)
public class ConsultaControladorPeliculaTest {

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void debeListarTresPeliculas() throws Exception {
		// Arrange

		// Act - Assert
		mocMvc.perform(get("/peliculas")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(3)));
	}
	
	@Test
	public void debeBuscarPorNombreYTenerLaInformacionCorrecta() throws Exception {
		// Arrange

		// Act - Assert
		mocMvc.perform(get("/peliculas/" + "Prueba")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.nombre", is("Prueba")))
				.andExpect(jsonPath("$.autor", is("Autor")))
				.andExpect(jsonPath("$.descripcion", is("Descripcion")));
	}
}
