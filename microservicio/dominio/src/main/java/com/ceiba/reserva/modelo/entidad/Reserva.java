package com.ceiba.reserva.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarFormatoAplicable;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.pelicula.modelo.entidad.Pelicula;

import lombok.Getter;

@Getter
public class Reserva {

	private static final String DEBE_INGRESAR_FECHA_RESERVA = "Debe ingresar una fecha de reserva";
	private static final String DEBE_INGRESAR_TIPO_RESERVA = "Debe ingresar un tipo de reserva";
	private static final String DEBE_INGRESAR_PELICULA = "Debe seleccionar una pelicula";
	private static final String RESERVA_NO_EN_FIN_DE_SEMANA = "La reserva no puede ser realizada en fin de semana";
	private static final String FECHA_INVALIDA = "La fecha ingresada no cumple el formato asignado";
	
	private Long id;
	private Double valor;
	private LocalDate fechaReserva;
	private LocalDate fechaDevolucion;
	private String tipoReserva;
	private Pelicula pelicula;
	
	public Reserva(Long id, String fechaReservaString, TipoReserva tipoReserva, Pelicula pelicula) {
		validarObligatorio(tipoReserva, DEBE_INGRESAR_TIPO_RESERVA);
		validarObligatorio(fechaReservaString, DEBE_INGRESAR_FECHA_RESERVA);
		validarObligatorio(pelicula, DEBE_INGRESAR_PELICULA);
		validarFormatoAplicable(fechaReservaString, "dd-MM-yyyy", FECHA_INVALIDA);
		
		LocalDate fechaReservaConvertida = convertirStringAFecha(fechaReservaString);
		validarFechaEnSemana(fechaReservaConvertida);
		
		this.id = id;
		this.fechaReserva = fechaReservaConvertida;
		this.fechaDevolucion = agregarDiasDevolucion(fechaReservaConvertida, tipoReserva.getDiasReserva());
		this.tipoReserva = tipoReserva.name();
		this.valor = tipoReserva.getValorReserva();
		this.pelicula = pelicula;
	}
	
	private static LocalDate agregarDiasDevolucion(LocalDate fechaReserva, int cantidadDias) {
		LocalDate fechaDevolucion = fechaReserva.plusDays(cantidadDias);
		switch(fechaDevolucion.getDayOfWeek()) {
			case SATURDAY:
				fechaDevolucion = fechaDevolucion.plusDays(2);
				break;
			case SUNDAY:
				fechaDevolucion = fechaDevolucion.plusDays(1);
				break;
			default:
				break;
		}
		
		return fechaDevolucion;
	}
	
	private static void validarFechaEnSemana(LocalDate fecha) {
		boolean esFinDeSemana = fecha.getDayOfWeek() == DayOfWeek.SATURDAY || fecha.getDayOfWeek() == DayOfWeek.SUNDAY;
		if(esFinDeSemana) {
			throw new ExcepcionValorInvalido(RESERVA_NO_EN_FIN_DE_SEMANA);
		}
	}
	
	private static LocalDate convertirStringAFecha(String fecha) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return LocalDate.parse(fecha, formato);
		
	}
}
