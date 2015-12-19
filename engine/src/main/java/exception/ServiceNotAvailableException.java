package exception;

/**
 * This exception is throw in case of general problem
 */
public class ServiceNotAvailableException extends Exception{
    public ServiceNotAvailableException() {
    }

    public ServiceNotAvailableException( String message, Throwable cause ) {
        super( message, cause );
    }

    public ServiceNotAvailableException( String message ) {
        super( message );
    }

    public ServiceNotAvailableException( Throwable cause ) {
        super( cause );
    }
}
