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
public class RolExisteException extends Exception {



    public RolExisteException(String e){
        super(e);
        
}
    public RolExisteException(String e, Throwable excepcionRaiz){
        super(e, excepcionRaiz);
    }

}
