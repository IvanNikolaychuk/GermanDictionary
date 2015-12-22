package validator.utils;

import exceptions.word.WordIsNotValidException;

public class WordValidatorUtils {
    public static final String SPACE = " ";

    /**
     *  In some languages article is a mandatory
     *  part of nouns, and the word should be learned
     *  with it's article.
     *
     */
    public static boolean isSingle( String word ) throws WordIsNotValidException {
        if ( word == null ) {
            throw new WordIsNotValidException( "Word shouldn't be null" );
        }
        return word.isEmpty() || word.split( " " ).length == 1;
    }

    public static boolean containsDigits( String word ) throws WordIsNotValidException {
        if ( word == null ) {
            throw new WordIsNotValidException( "Word shouldn't be null" );
        }

        return word.matches( ".*[0-9].*" );
    }

    /**
     * Example:
     * TEst Word -> Test word
     * wORD -> Word
     */
    public static String capitalizeFirstWordOthersToLower( String word ) throws WordIsNotValidException {
        if ( word == null ) {
            throw new WordIsNotValidException( "Word shouldn't be null" );
        }
        if ( word.isEmpty() ) {
            return word;
        }

        String wordWithoutFirstChar = word.substring( 1 );

        return Character.toUpperCase( word.charAt( 0 ) ) +
                wordWithoutFirstChar.toLowerCase();
    }

    /**
     *  Assume that first part of passed word is article.
     *  If not, returning capitalized word.
     *  Example:
     *  dAS auto -> das Auto
     *  auto -> Auto
     */
    public static String articleToLowerAndCapitalizeWord( String word ) throws WordIsNotValidException {
        if ( word == null ) {
            throw new WordIsNotValidException( "Word shouldn't be null" );
        }
        String[] splitWord = word.split( " " );
        if (splitWord.length < 2) {
            return capitalizeFirstWordOthersToLower( word );
        } else {
            String article = splitWord[0].toUpperCase();
            String wordWithoutArticle = word.substring( article.length() ).trim();

            return article.toLowerCase() + SPACE + capitalizeFirstWordOthersToLower( wordWithoutArticle );
        }
    }


}
