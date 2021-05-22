package com.ceiba.reserva.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pelicula.puerto.dao.DaoPelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;

@Component
public class FabricaReserva {

	private static final String PELICULA_CON_NOMBRE_NO_EXISTE = "No existe ninguna película con el nombre asignado";

	private final RepositorioPelicula repositorioPelicula;
	private final DaoPelicula daoPelicula;
	
	public FabricaReserva(RepositorioPelicula repositorioPelicula, DaoPelicula daoPelicula) {
		this.repositorioPelicula = repositorioPelicula;
		this.daoPelicula = daoPelicula;
	}
	
	public Reserva crear(ComandoReserva comandoReserva) {
		validarPeliculaExiste(comandoReserva.getNombre());
		
		Reserva reserva = new Reserva(
				comandoReserva.getId(), 
				comandoReserva.getValor(), 
				comandoReserva.getFechaReserva(), 
				comandoReserva.getFechaDevolucion(), 
				comandoReserva.getTipoReserva()
		);
		
		reserva.setPeliculaId(this.daoPelicula.encontrarId(comandoReserva.getNombre()));
		return reserva;
	}
	
	private void validarPeliculaExiste(String nombre) {
		boolean existe = this.repositorioPelicula.existe(nombre);
		if(!existe) {
			throw new ExcepcionDuplicidad(PELICULA_CON_NOMBRE_NO_EXISTE);
		}
	}
}
