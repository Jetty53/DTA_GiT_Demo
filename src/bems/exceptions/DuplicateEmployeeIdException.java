package bems.exceptions;

public class DuplicateEmployeeIdException extends RuntimeException {
    public DuplicateEmployeeIdException(String message) {
        super(message);
    }
}
