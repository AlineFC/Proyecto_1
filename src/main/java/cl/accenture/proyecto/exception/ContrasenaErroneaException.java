package cl.accenture.proyecto.exception;

import cl.accenture.proyecto.conexion.Conexion;

import java.sql.Connection;

public class ContrasenaErroneaException extends Exception {


    public ContrasenaErroneaException(String e){
        super(e);
    }

    public ContrasenaErroneaException(String e, Throwable excepcionRaiz){
        super(e, excepcionRaiz);
    }

}
