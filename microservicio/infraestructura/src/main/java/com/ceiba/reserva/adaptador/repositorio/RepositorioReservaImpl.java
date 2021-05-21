package com.ceiba.reserva.adaptador.repositorio;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class RepositorioReservaImpl implements RepositorioReserva {

	private final RepositorioReservaJPA repositorio;
	
	public RepositorioReservaImpl(RepositorioReservaJPA repositorioReservaJPA) {
		this.repositorio = repositorioReservaJPA;
	}
	
	@Override
	public Long crear(Reserva reservaInicial) {
		Reserva reserva = this.repositorio.save(reservaInicial);
		return reserva.getId();
	}

}
