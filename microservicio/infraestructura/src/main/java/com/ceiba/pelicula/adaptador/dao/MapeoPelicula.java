package com.ceiba.pelicula.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.pelicula.modelo.dto.DtoPelicula;

public class MapeoPelicula implements RowMapper<DtoPelicula>, MapperResult {

	@Override
	public DtoPelicula mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String autor = resultSet.getString("autor");
        String descripcion = resultSet.getString("descripcion");
        
		return new DtoPelicula(id, nombre, autor, descripcion);
	}

}
