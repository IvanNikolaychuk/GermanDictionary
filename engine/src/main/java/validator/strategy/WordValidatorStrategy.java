package validator.strategy;

import exceptions.word.WordIsNotValidException;

public interface WordValidatorStrategy {
    String validateAndGet( String word ) throws WordIsNotValidException;
}
