package com.ceiba.excepcion;

public class ExcepcionFormatoIncorrecto extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

    public ExcepcionFormatoIncorrecto(String mensaje) {
        super(mensaje);
    }
}
