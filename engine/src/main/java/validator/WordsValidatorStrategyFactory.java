package validator;

import context.EngineModuleContext;
import dictionary.word.WordType;
import org.springframework.context.ApplicationContext;
import validator.strategy.DefaultWordsValidatorStrategy;
import validator.strategy.RussianWordsValidatorStrategy;
import validator.strategy.WordsValidatorStrategy;

public class WordsValidatorStrategyFactory {
    public static WordsValidatorStrategy getWordsValidationStrategy( WordType wordType ) {
        WordsValidatorStrategy strategy;
        ApplicationContext context = EngineModuleContext.getContext();

        switch ( wordType ){
            case GERMAN:
                strategy = ( WordsValidatorStrategy ) context.getBean( "gerWordsValidator" );
                break;
            case RUSSIAN:
                strategy = ( RussianWordsValidatorStrategy ) context.getBean( "rusWordsValidator" );
                break;
            default:
                strategy = ( DefaultWordsValidatorStrategy ) context.getBean( "defWordsValidator" );
        }

        return strategy;
    }
}
