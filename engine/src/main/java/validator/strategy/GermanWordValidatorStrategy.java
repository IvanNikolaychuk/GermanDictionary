package validator.strategy;

import exceptions.word.WordIsNotValidException;

import static validator.utils.WordValidatorUtils.*;

public class GermanWordValidatorStrategy implements WordValidatorStrategy {

    public String validateAndGet( final String word ) throws WordIsNotValidException {
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
            if ( word.substring( 0, 3 ).equalsIgnoreCase( article ) ) {
                return true;
            }
        }

        return false;
    }
}
