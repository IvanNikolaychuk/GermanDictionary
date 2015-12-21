package validator.strategy;

import exceptions.word.WordContainsDigitsException;
import exceptions.word.WordIsNotValidException;

import static validator.utils.WordValidatorUtils.containsDigits;
import static validator.utils.WordValidatorUtils.capitalizeFirstWordOthersToLower;
import static validator.utils.WordValidatorUtils.isSingle;

public class DefaultWordsValidatorStrategy implements WordsValidatorStrategy {
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
            return capitalizeFirstWordOthersToLower( word );
        }
    }
}
