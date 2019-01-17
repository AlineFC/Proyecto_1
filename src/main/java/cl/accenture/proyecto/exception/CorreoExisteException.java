/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.accenture.proyecto.exception;

import cl.accenture.proyecto.conexion.Conexion;

import java.sql.Connection;

/**
 *
 * @author CrateX
 */
public class CorreoExisteException extends Exception{



    public CorreoExisteException(String e) {

        super(e);
}
    public CorreoExisteException(String e, Throwable excepcionRaiz){
        super(e, excepcionRaiz);
    }

    
}
