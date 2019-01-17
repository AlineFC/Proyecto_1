package cl.accenture.proyecto.model;


import java.util.ArrayList;

public class Empresa {

    private String id;
    private String nombre;
    ArrayList<Persona> empleado;
    ArrayList<Proyecto> proyectos;
    ArrayList<Usuario> usuarios;

    public Empresa(){

    }

    public Empresa(String id, String nombre, Persona persona, Usuario usuario, Proyecto proyecto ){
        this.id=id;
        this.nombre=nombre;
        this.empleado=empleado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Persona> getEmpleados() {
        return empleado;
    }

    public void setEmpleados(ArrayList<Persona> empleados) {
        this.empleado = empleados;
    }


    public ArrayList<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(ArrayList<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }



}
