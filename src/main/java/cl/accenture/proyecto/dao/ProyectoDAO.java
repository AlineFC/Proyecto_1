package cl.accenture.proyecto.dao;

import cl.accenture.proyecto.conexion.Conexion;
import cl.accenture.proyecto.exception.DriverException;
import cl.accenture.proyecto.exception.SinConexionException;
import cl.accenture.proyecto.model.Proyecto;

import java.sql.*;

public class ProyectoDAO {

private Conexion con;

    public ProyectoDAO(){

        this.con=new Conexion();

    }
    public void agregarProyecto(Proyecto proyecto) throws SinConexionException, DriverException {
        try {
            final String SQL = "insert into proyectos(idproyecto, nombre, fechainicio, fechatermino, status) values (?,?,?,?,?)" +
                    "VALUES(?,?,?,?,?)";

            PreparedStatement ps = Conexion.getConect().prepareStatement(SQL);
            ps.setInt(1,proyecto.getIdProyecto());
            ps.setString(2,proyecto.getNombreProyecto());
            //ps.setDate(3,proyecto.getFechaInicio(proyecto));
            //ps.setDate(3,proyecto.getFechaTermino(proyecto));
            ps.setBoolean(3,proyecto.isStatus());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean Status(Proyecto proyecto)throws SinConexionException,DriverException {

        try{
            final String SQL = "select * from proyecto where idproyecto";
            PreparedStatement ps = Conexion.getConect().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs.next() ){
                System.out.println( "Proyecto activo ");
            }else{
                System.out.println( "Proyecto inactivo");
            }
            return rs.next();
        }catch (SQLException e){
            return false;
        }
    }

    public void EditarProyecto(Proyecto proyecto)throws SinConexionException,DriverException {

        try {
            String sqledit = "UPDATE proyectos";
            sqledit += " set nombre = '" + proyecto.getNombreProyecto() + "',";
             sqledit += " set FechaInicio = '" + proyecto.getFechaInicio() + "',";
             sqledit += " set FechaTermino = '" + proyecto.getFechaTermino() + "'";
             sqledit += " WHERE idproyecto = '" + proyecto.getIdProyecto() + "'";

            Connection con = Conexion.getConect();
            Statement s = con.createStatement();
            System.out.println("SQL: " + sqledit);
            s.executeUpdate(sqledit);
            con.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
        }
    }

    public void eliminarProyecto(Proyecto proyecto)throws SinConexionException,DriverException {
        try {
            String sqldel = "DELETE FROM Proyectos";
            sqldel += " WHERE idUser = '" + proyecto.getIdProyecto() + "'";

            Connection con = Conexion.getConect();
            Statement s = con.createStatement();
            System.out.println("SQL: " + sqldel);
            s.executeUpdate(sqldel);

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
        }
    }




}
