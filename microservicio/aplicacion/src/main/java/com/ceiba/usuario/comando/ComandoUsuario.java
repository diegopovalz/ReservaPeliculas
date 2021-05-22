package com.ceiba.usuario.comando;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoUsuario{

    private Long id;
    private String nombre;
    private String clave;
    private LocalDateTime fecha;
    
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getClave() {
		return clave;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}    
}
