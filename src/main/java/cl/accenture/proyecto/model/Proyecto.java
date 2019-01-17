package cl.accenture.proyecto.model;

import java.util.*;

public class Proyecto {

    private int idProyecto;
    private String nombreProyecto;
    private java.sql.Date fechaInicio;
    private java.sql.Date fechaTermino;
    private boolean Status;

    public Proyecto(){

    }

    public Proyecto(int idProyecto, String nombreProyecto, java.sql.Date fechaInicio, java.sql.Date fechaTermino, Boolean Status){

        this.idProyecto = idProyecto;
        this.nombreProyecto=nombreProyecto;
        this.fechaInicio=fechaInicio;
        this.fechaTermino=fechaTermino;
        this.Status=Status;

    }


    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(java.sql.Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(java.sql.Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }



}
