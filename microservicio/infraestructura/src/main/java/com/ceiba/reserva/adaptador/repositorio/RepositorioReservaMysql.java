package com.ceiba.reserva.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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

    @SqlStatement(namespace="pelicula", value="reservar")
    private static String sqlReservar;
	
	public RepositorioReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

	@Override
	public Long crear(Reserva reserva) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
	    paramSource.addValue("estaReservada", "T");
	    paramSource.addValue("id", reserva.getPeliculaId());
		this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlReservar, paramSource);
		return this.customNamedParameterJdbcTemplate.crear(reserva, sqlCrear);
	}

}
