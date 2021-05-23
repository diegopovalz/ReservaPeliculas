package com.ceiba.error;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ceiba.excepcion.ExcepcionNoExiste;
import com.ceiba.infraestructura.error.Error;

@ControllerAdvice
public class ManejadorErrorPelicula extends ResponseEntityExceptionHandler {
    private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

    public ManejadorErrorPelicula() {
        CODIGOS_ESTADO.put(ExcepcionNoExiste.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(value = {ExcepcionNoExiste.class})
    public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
        String excepcionNombre = exception.getClass().getSimpleName();
        String mensaje = exception.getMessage();
        Integer codigo = CODIGOS_ESTADO.get(excepcionNombre);

        Error error = new Error(excepcionNombre, mensaje);
        return new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
    }
}
