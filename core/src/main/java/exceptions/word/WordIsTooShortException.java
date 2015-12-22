package exceptions.word;

public class WordIsTooShortException extends WordIsNotValidException {
    public WordIsTooShortException( Throwable cause ) {
        super( cause );
    }

    public WordIsTooShortException( String message ) {
        super( message );
    }

    public WordIsTooShortException( String message, Throwable cause ) {
        super( message, cause );
    }
}
