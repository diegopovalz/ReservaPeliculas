package com.ceiba.reserva.adaptador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.reserva.modelo.entidad.Reserva;

public interface RepositorioReservaJPA extends JpaRepository<Reserva, Long> {

}
