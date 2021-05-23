package com.ceiba.reserva.comando.fabrica;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.excepcion.ExcepcionFormatoIncorrecto;
import com.ceiba.excepcion.ExcepcionNoExiste;
import com.ceiba.pelicula.puerto.dao.DaoPelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;

@Component
public class FabricaReserva {

	private static final String PELICULA_CON_NOMBRE_NO_EXISTE = "No existe ninguna pelicula con el nombre asignado";
	private static final String FECHA_CON_FORMATO_INCORRECTO = "El formato de la fecha es incorrecto";

	private final RepositorioPelicula repositorioPelicula;
	private final DaoPelicula daoPelicula;
	
	@Autowired
	public FabricaReserva(RepositorioPelicula repositorioPelicula, DaoPelicula daoPelicula) {
		this.repositorioPelicula = repositorioPelicula;
		this.daoPelicula = daoPelicula;
	}
	
	public Reserva crear(ComandoReserva comandoReserva) {
		validarPeliculaExiste(comandoReserva.getNombre());
		Date fechaReserva = convertirFecha(comandoReserva.getFechaReserva());
		Date fechaDevolucion = convertirFecha(comandoReserva.getFechaDevolucion());
		Long peliculaId = this.daoPelicula.encontrarId(comandoReserva.getNombre());
		
		return new Reserva(
				comandoReserva.getId(), 
				comandoReserva.getValor(), 
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
	
	private Date convertirFecha(String fecha) {
		DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		try {
			return formato.parse(fecha);
		} catch (ParseException e) {
			throw new ExcepcionFormatoIncorrecto(FECHA_CON_FORMATO_INCORRECTO);
		}
	}
}
