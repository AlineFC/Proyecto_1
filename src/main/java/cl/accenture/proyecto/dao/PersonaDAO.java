package cl.accenture.proyecto.dao;
import cl.accenture.proyecto.conexion.Conexion;
import cl.accenture.proyecto.exception.DriverException;
import cl.accenture.proyecto.exception.SinConexionException;
import cl.accenture.proyecto.model.Persona;
import cl.accenture.proyecto.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {

    private Conexion conexion;

    public PersonaDAO() {
        this.conexion = new Conexion();
    }

    public void agregarEmpleado(Persona persona) throws SinConexionException,DriverException {
        try {
            final String SQL = "insert into usertable(id, rut, nombre,cargo, habilidad, proyecto, myhash) values (?,?,?,?,?,?,?)" +
                    "VALUES(?,?,?,?,?,?,?)";

            PreparedStatement ps = Conexion.getConect().prepareStatement(SQL);
            ps.setInt(1,persona.getIdPersona());
            ps.setString(2,persona.getRut());
            ps.setString(3,persona.getNombre());
            ps.setString(4,persona.getCargo());
            ps.setString(5,persona.getHabilidad());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Persona> obtenerEmpleado(String nombre) throws SinConexionException,DriverException {
        List<Persona> personas = new ArrayList<Persona>();
        try {
            final String SQL = "SELECT * from persona";
            PreparedStatement ps = Conexion.getConect().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setRut(rs.getString(3));
                persona.setCargo(rs.getString(4));
                persona.setHabilidad(rs.getString(5));
                //persona.setProyecto(rs.getProyecto(5));

                personas.add(persona);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return personas;
    }

    public List<Persona> buscarPersonasNombre(String nombre) throws SinConexionException, DriverException {
        List<Persona> personas = new ArrayList<Persona>();
        try {
            final String SQL = "SELECT * from personas where nombre = ?";
            PreparedStatement ps = Conexion.getConect().prepareStatement(SQL);
            ps.setString(1,nombre);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(rs.getInt(1));
                persona.setRut(rs.getString(2));
                persona.setNombre(rs.getString(3));
                persona.setCargo(rs.getString(4));
                persona.setHabilidad(rs.getString(5));
                //persona.setProyecto(rs.getInt(5));
                personas.add(persona);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return personas;
    }
    public List<Persona> buscarPersonasEmail(String email) throws SinConexionException,DriverException {
        List<Persona> personas = new ArrayList<Persona>();
        try {
            final String SQL = "SELECT * from Empleados where email = ?";
            PreparedStatement ps = Conexion.getConect().prepareStatement(SQL);
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setRut(rs.getString(3));
                persona.setCargo(rs.getString(4));
                persona.setHabilidad(rs.getString(5));
                //persona.setProyecto(rs.getStatement(4));
                personas.add(persona);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return personas;
    }
}
