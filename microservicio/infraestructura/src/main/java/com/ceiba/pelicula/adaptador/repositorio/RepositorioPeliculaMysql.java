package com.ceiba.pelicula.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pelicula.modelo.entidad.EstadoPelicula;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;

@Repository
public class RepositorioPeliculaMysql implements RepositorioPelicula {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="pelicula", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="pelicula", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="pelicula", value="estaReservada")
    private static String sqlEstaReservada;
    
    public RepositorioPeliculaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
    
	@Override
	public boolean existe(String nombre) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
	}

	@Override
	public Long crear(Pelicula pelicula) {
		return this.customNamedParameterJdbcTemplate.crear(pelicula, sqlCrear);
	}

	@Override
	public boolean estaReservada(String nombre) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);
        paramSource.addValue("estadoPelicula", EstadoPelicula.RESERVADA.name());
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlEstaReservada, paramSource, Boolean.class);
	}

}
