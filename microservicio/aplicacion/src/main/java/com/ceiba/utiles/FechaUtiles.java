package com.ceiba.utiles;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

public final class FechaUtiles {
	
	private static final String FORMATO_INVALIDO = "El formato de la fecha es invalido";
	private static final String FECHA_INVALIDA = "La fecha ingresada no cumple el formato asignado";
	private static final String FECHA_NO_CONVERTIDA = "La fecha ingresada no puede ser convertida con el formato asignado";
	
	private FechaUtiles() { }

	public static LocalDate agregarDias(LocalDate fechaInicial, int cantidadDias) {
		fechaInicial = fechaInicial.plusDays(cantidadDias);
		switch(fechaInicial.getDayOfWeek()) {
			case SATURDAY:
				fechaInicial = fechaInicial.plusDays(2);
				break;
			case SUNDAY:
				fechaInicial = fechaInicial.plusDays(1);
				break;
			default:
				break;
		}
		
		return fechaInicial;
	}
	
	public static LocalDate convertirStringAFecha(String fecha, String formatoFecha) {
		try {
			DateTimeFormatter formato = DateTimeFormatter.ofPattern(formatoFecha);
			return LocalDate.parse(fecha, formato);
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException(FORMATO_INVALIDO);
		} catch (DateTimeParseException e) {
			throw new ExcepcionValorInvalido(FECHA_INVALIDA);
		}
	}
	
	public static String convertirFechaAString(LocalDate fecha, String formatoFecha) {
		try {
			DateTimeFormatter formato = DateTimeFormatter.ofPattern(formatoFecha);
			return fecha.format(formato);
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException(FORMATO_INVALIDO);
		} catch (DateTimeException e) {
			throw new ExcepcionValorInvalido(FECHA_NO_CONVERTIDA);
		}
	}
}
