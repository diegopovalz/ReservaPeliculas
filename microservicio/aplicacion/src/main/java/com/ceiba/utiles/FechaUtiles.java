package com.ceiba.utiles;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.ceiba.dominio.ValidadorArgumento.validarFechaConvertible;
import static com.ceiba.dominio.ValidadorArgumento.validarFormatoAplicable;

public final class FechaUtiles {
	
	private static final String FORMATO_INVALIDO = "La fecha no pudo ser convertida debido a que el formato %s no es valido";
	private static final String FECHA_INVALIDA = "La fecha ingresada no cumple el formato asignado";
	
	private FechaUtiles() { }

	public static LocalDate agregarDiasDevolucion(LocalDate fechaInicial, int cantidadDias) {
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
		validarFormatoAplicable(fecha, formatoFecha, FECHA_INVALIDA);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern(formatoFecha);
		return LocalDate.parse(fecha, formato);
		
	}
	
	public static String convertirFechaAString(LocalDate fecha, String formatoFecha) {
		validarFechaConvertible(fecha, formatoFecha, String.format(FORMATO_INVALIDO, formatoFecha));
		DateTimeFormatter formato = DateTimeFormatter.ofPattern(formatoFecha);
		return fecha.format(formato);
	}
}
