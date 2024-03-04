package dev.patika.VeterineryManagementSystem.core.exception;

public class AlreadyRegisterException extends RuntimeException{
    public AlreadyRegisterException(String message){
        super(message);
    }

}
