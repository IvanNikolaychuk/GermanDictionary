package validator;

import context.EngineModuleContext;
import dictionary.word.WordType;
import org.springframework.context.ApplicationContext;
import validator.strategy.DefaultWordValidatorStrategy;
import validator.strategy.RussianWordValidatorStrategy;
import validator.strategy.WordValidatorStrategy;

public class WordsValidatorStrategyFactory {
    public static WordValidatorStrategy getWordsValidationStrategy( WordType wordType ) {
        WordValidatorStrategy strategy;
        ApplicationContext context = EngineModuleContext.getContext();

        switch ( wordType ){
            case GERMAN:
                strategy = ( WordValidatorStrategy ) context.getBean( "gerWordsValidator" );
                break;
            case RUSSIAN:
                strategy = ( RussianWordValidatorStrategy ) context.getBean( "rusWordsValidator" );
                break;
            default:
                strategy = ( DefaultWordValidatorStrategy ) context.getBean( "defWordsValidator" );
        }

        return strategy;
    }
}
