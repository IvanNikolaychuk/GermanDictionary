package utils;

import dictionary.training.TrainingUnit;
import dictionary.word.Word;
import dictionary.word.WordPair;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class TrainingDaoUtils {

    public static TrainingUnit generateUnitFromResultSet( ResultSet rs ) throws SQLException {
        TrainingUnit unit;

        String gerWord = rs.getString( "ger_word" );
        String rusWord = rs.getString( "rus_word" );
        boolean isLearned = rs.getBoolean( "learned" );
        int id = rs.getInt( "id" );

        WordPair wordPair = new WordPair( new Word( gerWord ), new Word( rusWord ) );
        unit = new TrainingUnit( wordPair );
        unit.setLearned( isLearned );
        unit.setId( id );

        return unit;
    }
}
