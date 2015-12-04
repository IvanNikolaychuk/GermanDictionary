package exceptions.user;

/**
 * This exception is throw in case of general problem
 */
public class UserException extends Exception {
    public UserException() {
    }

    public UserException( String message ) {
        super( message );
    }

    public UserException( String message, Throwable cause ) {
        super( message, cause );
    }
}
