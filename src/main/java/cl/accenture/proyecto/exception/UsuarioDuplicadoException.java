package cl.accenture.proyecto.exception;

import cl.accenture.proyecto.conexion.Conexion;

import java.sql.Connection;

public class UsuarioDuplicadoException extends Exception {

    public UsuarioDuplicadoException(String e){
        super(e);

    }
    public UsuarioDuplicadoException(String e, Throwable excepcionRaiz){
        super(e, excepcionRaiz);
    }

}
