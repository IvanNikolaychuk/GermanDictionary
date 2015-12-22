package utils;

import dictionary.training.TrainingUnit;
import dictionary.word.Word;
import dictionary.word.WordPair;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class TrainingDaoUtils {

    /**
     * This method doesn't close {@code rs},
     * calling it, assume, it is closed on your side.
     */
    public static TrainingUnit generateUnitFromResultSet( ResultSet rs ) throws SQLException {
        TrainingUnit unit;

        String gerWord = rs.getString( "ger_word" );
        String rusWord = rs.getString( "rus_word" );
        boolean isLearned = rs.getBoolean( "learned" );
        int id = rs.getInt( "id" );

        WordPair wordPair = new WordPair( rusWord, gerWord );
        unit = new TrainingUnit( wordPair );
        unit.setLearned( isLearned );
        unit.setId( id );

        return unit;
    }
}
