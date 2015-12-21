package validator;

import context.EngineModuleContext;
import dictionary.word.WordType;
import exceptions.word.WordIsNotValidException;
import validator.strategy.WordsValidatorStrategy;

public class WordsValidator {
    public static String validate( String word, WordType wordType ) throws WordIsNotValidException {
        WordsValidatorStrategy strategy =
                WordsValidatorStrategyFactory.getWordsValidationStrategy( wordType );

        return strategy.validateAndGet( word );
    }
    public static String validate( String word ) throws WordIsNotValidException {
        WordsValidatorStrategy strategy =
                ( WordsValidatorStrategy ) EngineModuleContext.getContext().
                        getBean( "defaultWordsValidator" );

        return strategy.validateAndGet( word );

    }
}
