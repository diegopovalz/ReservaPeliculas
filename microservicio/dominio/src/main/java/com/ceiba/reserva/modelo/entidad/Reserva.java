package com.ceiba.reserva.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Reserva {

	private static final String DEBE_INGRESAR_FECHA_RESERVA = "Debe ingresar una fecha de reserva";
	private static final String DEBE_INGRESAR_FECHA_DEVOLUCION = "Debe ingresar una fecha de devolucion";
	private static final String DEBE_INGRESAR_TIPO_RESERVA = "Debe ingresar un tipo de reserva";
	
	private Long id;
	private Double valor;
	private LocalDate fechaReserva;
	private LocalDate fechaDevolucion;
	private String tipoReserva;
	private Long peliculaId;
	
	public Reserva(Long id, LocalDate fechaReserva, LocalDate fechaDevolucion, TipoReserva tipoReserva, Long peliculaId) {
		validarObligatorio(fechaReserva, DEBE_INGRESAR_FECHA_RESERVA);
		validarObligatorio(fechaDevolucion, DEBE_INGRESAR_FECHA_DEVOLUCION);
		validarObligatorio(tipoReserva, DEBE_INGRESAR_TIPO_RESERVA);
		
		this.id = id;
		this.fechaReserva = fechaReserva;
		this.fechaDevolucion = fechaDevolucion;
		this.tipoReserva = tipoReserva.name();
		this.valor = tipoReserva.getValorReserva();
		this.peliculaId = peliculaId;
	}
	
}
