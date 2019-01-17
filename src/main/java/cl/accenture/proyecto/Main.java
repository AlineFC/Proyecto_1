package cl.accenture.proyecto;

import cl.accenture.proyecto.conexion.Conexion;
import cl.accenture.proyecto.dao.RolDAO;
import cl.accenture.proyecto.model.Rol;

import java.sql.PreparedStatement;


public class Main {
    public static void main(String args[])throws Exception {

        RolDAO rolDAO=new RolDAO();
        Rol rolcito=new Rol(1,"admin","sjkadjkja");

        rolDAO.agregarRol(rolcito);




    }
}
