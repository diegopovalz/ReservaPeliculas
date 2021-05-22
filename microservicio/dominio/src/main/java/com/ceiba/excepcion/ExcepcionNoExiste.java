package com.ceiba.excepcion;

public class ExcepcionNoExiste  extends RuntimeException{
	private static final long serialVersionUID = 1L;

    public ExcepcionNoExiste(String mensaje) {
        super(mensaje);
    }
}
