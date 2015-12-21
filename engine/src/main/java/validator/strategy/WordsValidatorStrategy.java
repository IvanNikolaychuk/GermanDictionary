package validator.strategy;

import exceptions.word.WordIsNotValidException;

public interface WordsValidatorStrategy {
    String validateAndGet( String word) throws WordIsNotValidException;
}
