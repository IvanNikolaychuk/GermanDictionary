package validator.strategy;

import exceptions.word.WordContainsDigitsException;
import exceptions.word.WordIsNotValidException;

import static validator.utils.WordValidatorUtils.*;

public class GermanWordsValidatorStrategy implements WordsValidatorStrategy {

    public String validateAndGet( final String word ) throws WordIsNotValidException {
        if ( word == null ) {
            throw new WordIsNotValidException( "Word shouldn't be null" );
        }

        if ( containsDigits( word ) ) {
            throw new WordContainsDigitsException( word + " contains digit" );
        }

        if ( isSingle( word ) ) {
            return word.toLowerCase();
        } else {
            return isNoun( word ) ? articleToLowerAndCapitalizeWord( word ) :
                    capitalizeFirstWordOthersToLower( word );
        }
    }

    private boolean isNoun( String word ) {
        final String[] articles = { "der", "die", "das" };

        for ( String article : articles ) {
            if ( word.substring( 0, 4 ).equalsIgnoreCase( article ) ) {
                return true;
            }
        }

        return false;
    }
}
