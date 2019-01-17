package cl.accenture.proyecto.exception;

public class StatmentException extends Exception {
    public StatmentException(String error,Throwable e){
        super(error,e);
    }
}
