package cl.accenture.proyecto.exception;

public class DriverException extends Exception {
    public DriverException(String mensajeError,Throwable e){
        super(mensajeError,e);
    }
}
