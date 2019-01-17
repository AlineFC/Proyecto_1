/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.accenture.proyecto.dao;

/**
 *
 * @author CrateX
 */
import java.sql.*;
import java.util.ArrayList;

import cl.accenture.proyecto.conexion.Conexion;
import cl.accenture.proyecto.exception.DriverException;
import cl.accenture.proyecto.exception.RolExisteException;
import cl.accenture.proyecto.exception.SinConexionException;
import cl.accenture.proyecto.exception.StatmentException;
import cl.accenture.proyecto.model.Rol;


public class RolDAO {

    private PreparedStatement ps;
    private Statement s;
    private Conexion con;

    public RolDAO(){
        this.con = new Conexion();
    }

    public void roladmin(Rol rol) throws SinConexionException {

        try {

            while (rol.getId() == 1) {
                System.out.println("Su rol es Administrador");
                if (rol.getId() == 2) {
                    System.out.println("Su rol corresponde a un usuario normal");
                } else {
                    System.out.println("Error en rol.");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void agregarRol(Rol rol) throws SinConexionException, DriverException,StatmentException {
        try {
            final String SQL = "insert into administradores(idRol, nombre, descripcion) VALUES(?,?,?)";

            PreparedStatement ps = Conexion.getConect().prepareStatement(SQL);
            ps.setInt(1,rol.getId());
            ps.setString(2,rol.getNombre());
            ps.setString(3,rol.getDescripcion());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new StatmentException("Error al ingresar el rol",e);
        }
    }

    public void EditarRol(Rol rol) throws SinConexionException,DriverException{

        try {
            String sqledit = "UPDATE administradores";
            sqledit += " set idRol = '" + rol.getId() + "',";
            sqledit += " set Descripcion = '" + rol.getDescripcion() + "',";
            sqledit += " set Nombre = '" + rol.getNombre() + "'";
            sqledit += " WHERE idRol = '" + rol.getId() + "'";

            Connection con = Conexion.getConect();
            Statement s = con.createStatement();
            System.out.println("SQL: " + sqledit);
            s.executeUpdate(sqledit);
            con.close();

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
        }
    }


    public ArrayList<Rol> obtenerRol() throws SinConexionException,DriverException,RolExisteException {

       ArrayList<Rol> roles = new ArrayList<>();

        try {
            ps = Conexion.getConect().prepareStatement("SELECT * FROM administradores");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Rol rol = new Rol();

                rol.setId(rs.getInt(1));
                rol.setNombre(rs.getString(2));
                rol.setDescripcion(rs.getString(3));

                roles.add(rol);
            }
            return roles;
        }catch (SQLException e){
            throw new RolExisteException("Rol existente",e);
        }
    }

    public void eliminarRol(Rol rol) throws RolExisteException,SinConexionException,DriverException,SQLException {


            ps = Conexion.getConect().prepareStatement("SELECT id FROM administradores WHERE idRol"
                    + " = ?");
            ps.setInt(1,rol.getId());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                throw new RolExisteException("Rol actualmente en uso");
            } else {
                ps = Conexion.getConect().prepareStatement("DELETE FROM administradores WHERE idRol = ?");
                ps.setInt(1,rol.getId());
                ps.executeUpdate();
                System.out.println("Datos eliminados correctamente.");
            }

}
}
