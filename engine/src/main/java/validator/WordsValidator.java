package validator;

import dictionary.word.WordType;
import exceptions.word.WordContainsDigitsException;
import exceptions.word.WordIsNotValidException;
import exceptions.word.WordIsTooShortException;
import validator.strategy.WordValidatorStrategy;

import static dictionary.word.WordType.DEFAULT;
import static validator.utils.WordValidatorUtils.containsDigits;

public class WordsValidator {
    public static String validateAndGet( String word, WordType wordType ) throws WordIsNotValidException {
        commonValidation( word );

        WordValidatorStrategy strategy =
                WordsValidatorStrategyFactory.getWordsValidationStrategy( wordType );

        return strategy.validateAndGet( word );
    }


    public static String validateAndGet( String word ) throws WordIsNotValidException {
        return validateAndGet( word, DEFAULT );
    }

    private static void commonValidation( String word ) throws WordIsNotValidException {
        if ( word == null ) {
            throw new WordIsNotValidException( "Word shouldn't be null" );
        }

        if ( containsDigits( word ) ) {
            throw new WordContainsDigitsException( word + " contains digit" );
        }

        if ( word.length() < 3 ) {
            throw new WordIsTooShortException( word + " contains " + word.length() +
                    " chars. 2 should be minimum." );
        }
    }

}
