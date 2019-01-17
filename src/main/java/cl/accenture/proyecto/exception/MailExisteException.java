package cl.accenture.proyecto.exception;

import cl.accenture.proyecto.conexion.Conexion;

import java.sql.Connection;

public class MailExisteException extends Exception {
    public MailExisteException(String e){

        super(e);
    }
    public MailExisteException(String e, Throwable excepcionRaiz){
        super(e, excepcionRaiz);
    }

}
