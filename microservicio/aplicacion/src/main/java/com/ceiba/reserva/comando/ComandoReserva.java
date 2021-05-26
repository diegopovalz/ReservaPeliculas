package com.ceiba.reserva.comando;

import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.reserva.modelo.entidad.TipoReserva;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoReserva {
	
	private Long id;
	private TipoReserva tipoReserva;
	private String fechaReserva;
	private Pelicula pelicula;
}
