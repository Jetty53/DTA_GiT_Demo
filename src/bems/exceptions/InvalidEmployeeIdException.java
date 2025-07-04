package bems.exceptions;

public class InvalidEmployeeIdException extends RuntimeException{
    public InvalidEmployeeIdException(String message){
        super(message);
    }
}
