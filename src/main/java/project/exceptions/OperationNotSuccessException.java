package project.exceptions;

public class OperationNotSuccessException extends RuntimeException {
    public OperationNotSuccessException(String message) {
        super(message);
    }
}
