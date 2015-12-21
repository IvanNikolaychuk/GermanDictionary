package exceptions.word;

public class WordContainsDigitsException extends WordIsNotValidException{
    public WordContainsDigitsException( Throwable cause ) {
        super( cause );
    }

    public WordContainsDigitsException( String message ) {
        super( message );
    }

    public WordContainsDigitsException( String message, Throwable cause ) {
        super( message, cause );
    }
}
