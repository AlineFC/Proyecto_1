package cl.accenture.proyecto.exception;

import cl.accenture.proyecto.conexion.Conexion;

import java.sql.Connection;

public class CampoEnBlancoException extends Exception {

    public CampoEnBlancoException(String e){
        super(e);
    }

    public CampoEnBlancoException(String e, Throwable excepcionRaiz){
        super(e, excepcionRaiz);
    }

}
