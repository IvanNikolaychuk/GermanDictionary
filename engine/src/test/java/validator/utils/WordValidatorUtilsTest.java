package validator.utils;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static validator.utils.WordValidatorUtils.*;

public class WordValidatorUtilsTest {
    private final static String STRING_DEFAULT  = "<def>";
    private final static String STRING_TEST_LOWER_CASE  = "test";
    private final static String STRING_TEST_CAPITALIZED  = "Test";
    private final static String STRING_EMPTY  = "";
    private final static String ARTICLE  = "der";
    private final static String SPACE  = " ";

    @Test
    public void isSingle() throws Exception {
        assertTrue(WordValidatorUtils.isSingle( STRING_EMPTY ));
        assertTrue(WordValidatorUtils.isSingle( STRING_DEFAULT ));
        assertFalse(WordValidatorUtils.isSingle( STRING_DEFAULT + SPACE + STRING_DEFAULT ));
    }

    @Test
    public void containsDigits() throws Exception {
        assertFalse(WordValidatorUtils.containsDigits( STRING_EMPTY ));
        assertFalse(WordValidatorUtils.containsDigits( STRING_DEFAULT ));
        assertTrue(WordValidatorUtils.isSingle( "123" ));
        assertTrue(WordValidatorUtils.isSingle( "1" + STRING_DEFAULT + "2" ));
    }

    @Test
    public void capitalizeFirstOnlyWordOthersToLower() throws Exception {
        assertEquals( capitalizeFirstWordOthersToLower( STRING_EMPTY ), STRING_EMPTY );
        assertEquals( capitalizeFirstWordOthersToLower( STRING_TEST_LOWER_CASE ), STRING_TEST_CAPITALIZED );
        assertEquals( capitalizeFirstWordOthersToLower(
                STRING_TEST_LOWER_CASE + SPACE + STRING_TEST_LOWER_CASE ),
                STRING_TEST_CAPITALIZED + SPACE + STRING_TEST_LOWER_CASE );
    }

    @Test
    public void articleToLowerCapitalizeWord() throws Exception {
        assertEquals( articleToLowerAndCapitalizeWord( STRING_EMPTY ), STRING_EMPTY );
        assertEquals( articleToLowerAndCapitalizeWord(
                ARTICLE.toUpperCase() + SPACE + STRING_TEST_LOWER_CASE ),
                ARTICLE + SPACE + STRING_TEST_CAPITALIZED );

        assertEquals( articleToLowerAndCapitalizeWord(
                ARTICLE + SPACE + STRING_TEST_CAPITALIZED ),
                ARTICLE + SPACE + STRING_TEST_CAPITALIZED );
    }
}
