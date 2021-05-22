package com.ceiba.reserva.adaptador.repositorio;

import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

@Repository
public class RepositorioReservaMysql implements RepositorioReserva {
	
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@SqlStatement(namespace="reserva", value="crear")
    private static String sqlCrear;
	
	public RepositorioReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

	@Override
	public Long crear(Reserva reserva) {
		return this.customNamedParameterJdbcTemplate.crear(reserva, sqlCrear);
	}

}
