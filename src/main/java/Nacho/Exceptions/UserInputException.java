package Nacho.Exceptions;

public class UserInputException extends RuntimeException{
    // Custom exception that gets thrown when user is missing mandatory fields in their commands
    public UserInputException(String message) {
        super(message);
    }
}
