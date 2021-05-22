package com.ceiba.reserva.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.util.Date;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Reserva {

	private static final String DEBE_INGRESAR_VALOR = "Debe ingresar un valor para la reserva";
	private static final String DEBE_INGRESAR_FECHA_RESERVA = "Debe ingresar una fecha de reserva";
	private static final String DEBE_INGRESAR_FECHA_DEVOLUCION = "Debe ingresar una fecha de devolucion";
	private static final String DEBE_INGRESAR_TIPO_RESERVA = "Debe ingresar un tipo de reserva";
	
	private Long id;
	private Double valor;
	private Date fechaReserva;
	private Date fechaDevolucion;
	private String tipoReserva;
	private Long peliculaId;
	
	public Reserva(Long id, Double valor, Date fechaReserva, Date fechaDevolucion, TipoReserva tipoReserva) {
		validarObligatorio(valor, DEBE_INGRESAR_VALOR);
		validarObligatorio(fechaReserva, DEBE_INGRESAR_FECHA_RESERVA);
		validarObligatorio(fechaDevolucion, DEBE_INGRESAR_FECHA_DEVOLUCION);
		validarObligatorio(tipoReserva, DEBE_INGRESAR_TIPO_RESERVA);
		
		this.id = id;
		this.valor = valor;
		this.fechaReserva = fechaReserva;
		this.fechaDevolucion = fechaDevolucion;
		this.tipoReserva = tipoReserva.name();
	}
	
	public Long getId() {
		return id;
	}

	public Double getValor() {
		return valor;
	}
	
	public Date getFechaReserva() {
		return fechaReserva;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public String getTipoReserva() {
		return tipoReserva;
	}

	public Long getPeliculaId() {
		return peliculaId;
	}
	
	public void setPeliculaId(Long peliculaId) {
		this.peliculaId = peliculaId;
	}
	
}
