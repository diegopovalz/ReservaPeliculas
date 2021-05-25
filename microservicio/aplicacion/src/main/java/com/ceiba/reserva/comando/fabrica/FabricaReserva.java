package com.ceiba.reserva.comando.fabrica;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.dominio.excepcion.ExcepcionNoExiste;
import com.ceiba.pelicula.puerto.dao.DaoPelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.utiles.FechaUtiles;

@Component
public class FabricaReserva {

	private static final String PELICULA_CON_NOMBRE_NO_EXISTE = "No existe ninguna pelicula con el nombre asignado";

	private final RepositorioPelicula repositorioPelicula;
	private final DaoPelicula daoPelicula;
	
	@Autowired
	public FabricaReserva(RepositorioPelicula repositorioPelicula, DaoPelicula daoPelicula) {
		this.repositorioPelicula = repositorioPelicula;
		this.daoPelicula = daoPelicula;
	}
	
	public Reserva crear(ComandoReserva comandoReserva) {
		validarPeliculaExiste(comandoReserva.getNombrePelicula());
		Long peliculaId = this.daoPelicula.encontrarId(comandoReserva.getNombrePelicula());
		LocalDate fechaReserva = FechaUtiles.convertirStringAFecha(comandoReserva.getFechaReserva(), "dd-MM-yyyy");
		LocalDate fechaDevolucion = FechaUtiles.agregarDiasDevolucion(fechaReserva, comandoReserva.getTipoReserva().getDiasReserva());
		
		return new Reserva(
				comandoReserva.getId(), 
				fechaReserva,
				fechaDevolucion, 
				comandoReserva.getTipoReserva(),
				peliculaId
		);
	}
	
	private void validarPeliculaExiste(String nombre) {
		boolean existe = this.repositorioPelicula.existe(nombre);
		if(!existe) {
			throw new ExcepcionNoExiste(PELICULA_CON_NOMBRE_NO_EXISTE);
		}
	}
}
