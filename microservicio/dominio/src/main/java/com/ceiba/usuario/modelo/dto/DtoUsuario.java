package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class DtoUsuario {
    private Long id;
    private String nombre;
    private String clave;
    private LocalDateTime fechaCreacion;
    
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getClave() {
		return clave;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

    
}
