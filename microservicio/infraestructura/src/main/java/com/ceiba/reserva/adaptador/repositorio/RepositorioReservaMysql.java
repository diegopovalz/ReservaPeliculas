package com.ceiba.reserva.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pelicula.modelo.entidad.EstadoPelicula;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

@Repository
public class RepositorioReservaMysql implements RepositorioReserva {
	
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@SqlStatement(namespace="reserva", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="pelicula", value="reservar")
    private static String sqlReservar;
    
    @SqlStatement(namespace="pelicula", value="encontrarId")
    private static String sqlEncontrarId;
    
    @SqlStatement(namespace="reserva", value="asignarIdPelicula")
    private static String sqlAsignarIdPelicula;
    
	public RepositorioReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

	@Override
	public Long crear(Reserva reserva) {
		// Mapa de Parametros
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
	    paramSource.addValue("estadoPelicula", EstadoPelicula.RESERVADA.name());
	    paramSource.addValue("nombre", reserva.getPelicula().getNombre());
	    
	    // Pone la película como RESERVADA
		this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlReservar, paramSource);
		
		// Obtiene el ID de la nueva reserva
		Long reservaId = this.customNamedParameterJdbcTemplate.crear(reserva, sqlCrear);
		
		// Obtiene el ID de la pelicula recién reservada
		Long peliculaId = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlEncontrarId, paramSource, Long.class);
	    paramSource.addValue("peliculaId", peliculaId);
	    paramSource.addValue("reservaId", reservaId);
	    
	    // Asigna el ID de la película a la reserva
		this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlAsignarIdPelicula, paramSource);
		return reservaId;
	}

}
