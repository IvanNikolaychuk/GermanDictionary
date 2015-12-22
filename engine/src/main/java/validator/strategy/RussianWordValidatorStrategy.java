package validator.strategy;

import exceptions.word.WordIsNotValidException;

import static validator.utils.WordValidatorUtils.capitalizeFirstWordOthersToLower;
import static validator.utils.WordValidatorUtils.isSingle;

public class RussianWordValidatorStrategy implements WordValidatorStrategy {
    public String validateAndGet( final String word ) throws WordIsNotValidException {
        if ( isSingle( word ) ) {
            return word.toLowerCase();
        } else {
            return capitalizeFirstWordOthersToLower( word );
        }
    }
}
