package com.ceiba.reserva.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ceiba.pelicula.modelo.entidad.Pelicula;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "reservas")
public class Reserva {

	private static final String DEBE_INGRESAR_VALOR = "";
	private static final String DEBE_INGRESAR_FECHA_RESERVA = "";
	private static final String DEBE_INGRESAR_FECHA_DEVOLUCION = "";
	private static final String DEBE_INGRESAR_TIPO_RESERVA = "";
	
	@Id
	@GeneratedValue
	private Long id;
	private Double valor;
	private Date fechaReserva;
	private Date fechaDevolucion;
	private TipoReserva tipoReserva;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pelicula_id", referencedColumnName = "id")
	private Pelicula pelicula;
	
	public Reserva(Long id, Double valor, Date fechaReserva, Date fechaDevolucion, TipoReserva tipoReserva) {
		validarObligatorio(valor, DEBE_INGRESAR_VALOR);
		validarObligatorio(fechaReserva, DEBE_INGRESAR_FECHA_RESERVA);
		validarObligatorio(fechaDevolucion, DEBE_INGRESAR_FECHA_DEVOLUCION);
		validarObligatorio(tipoReserva, DEBE_INGRESAR_TIPO_RESERVA);
		
		this.id = id;
		this.fechaReserva = fechaReserva;
		this.fechaDevolucion = fechaDevolucion;
		this.tipoReserva = tipoReserva;
	}
	
}
