package com.ceiba.pelicula.adaptador.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pelicula.modelo.dto.DtoPelicula;
import com.ceiba.pelicula.puerto.dao.DaoPelicula;

@Component
public class DaoPeliculaMysql implements DaoPelicula {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@SqlStatement(namespace="pelicula", value="listar")
    private static String sqlListar;
	
	@SqlStatement(namespace="pelicula", value="encontrar")
    private static String sqlEncontrar;
	
	@SqlStatement(namespace="pelicula", value="encontrarId")
    private static String sqlEncontrarId;
	
	public DaoPeliculaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
	
	@Override
	public List<DtoPelicula> listar() {
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPelicula());
	}

	@Override
	public DtoPelicula encontrar(String name) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", name);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlEncontrar, paramSource, new MapeoPelicula());
	}

	@Override
	public Long encontrarId(String nombre) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlEncontrarId, paramSource, Long.class);
	}

}
