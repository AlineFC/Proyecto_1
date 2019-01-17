/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.accenture.proyecto.conexion;

/**
 *
 * @author CrateX
 */
import cl.accenture.proyecto.exception.DriverException;
import cl.accenture.proyecto.exception.SinConexionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    static Connection con;

    public static Connection getConect()throws DriverException,SinConexionException{

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto","root","petsociety,19");

        }
        catch(ClassNotFoundException e){
            throw new DriverException("Error al cargar el driver", e);

        }catch (SQLException e){
            throw new SinConexionException("Error al conectar con la base de datos",e);
        }

        return con;
    }

    public Connection getConexion(){

        return con;

    }

    public void desconectar() {

        con = null;

        if (con == null) {

            System.out.println("Desconectado.");

        }
    }
}
