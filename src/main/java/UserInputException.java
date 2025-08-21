public class UserInputException extends RuntimeException{
    // Custom exception that gets thrown when user is missing mandatory fields in their commands
    UserInputException(String message) {
        super(message);
    }
}
