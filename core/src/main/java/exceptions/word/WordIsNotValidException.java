package exceptions.word;

/**
 * This exception is throw in case of general problem
 */
public class WordIsNotValidException extends Exception {
    public WordIsNotValidException( Throwable cause ) {
        super( cause );
    }

    public WordIsNotValidException( String message ) {
        super( message );
    }

    public WordIsNotValidException() {
    }

    public WordIsNotValidException( String message, Throwable cause ) {
        super( message, cause );
    }
}
