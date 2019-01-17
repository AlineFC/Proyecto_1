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
public class UsuarioExisteException extends Exception {


    public UsuarioExisteException(String e){
        super(e);
}
    public UsuarioExisteException(String e, Throwable excepcionRaiz){
        super(e, excepcionRaiz);
    }

    
}
