package dao.training;

import dictionary.training.TrainingUnit;
import dictionary.word.Word;
import dictionary.word.WordPair;
import provider.DbConnectionProvider;
import java.sql.*;

public class TrainingDaoImpl implements TrainingUnitDao {
    private DbConnectionProvider connectionProvider;

    public TrainingDaoImpl( DbConnectionProvider connectionProvider ) {
        this.connectionProvider = connectionProvider;
    }

    public TrainingUnit getUnit( int id ) throws SQLException {
        Connection connection = null;
        Statement stmt = null;

        @SuppressWarnings( "all" )
        String selectSQL = "SELECT ger_word, rus_word, learned" +
                " FROM dictionary " +
                "WHERE id = " + id;
        TrainingUnit unit = null;
        try {
            connection = connectionProvider.getConnection();
            stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery( selectSQL );

            while ( rs.next() ) {
                String gerWord = rs.getString( "ger_word" );
                String rusWord = rs.getString( "rus_word" );
                boolean isLearned = rs.getBoolean( "learned" );

                WordPair wordPair = new WordPair( new Word( gerWord ), new Word( rusWord ) );
                unit = new TrainingUnit( wordPair );
                unit.setId( id );
                unit.setLearned( isLearned );
            }

            if ( unit == null ) {
                // todo: make normal exceptions
                throw new SQLException( "No unit with id " + id );
            }

            return unit;
        } finally {
            if ( connection != null ) {
                connection.close();
            }
            if ( stmt != null ) {
                connection.close();
            }
        }
    }

    public void insertUnit( TrainingUnit unit ) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;

        @SuppressWarnings( "all" )
        String insertSQL = "INSERT INTO" +
                " dictionary(ger_word, rus_word, learned) " +
                "VALUES (?,?,?)";
        try {
            connection = connectionProvider.getConnection();
            stmt = connection.prepareStatement( insertSQL );

            WordPair wordPair = unit.getWordPair();

            stmt.setString( 1, wordPair.getGermanWord().getValue() );
            stmt.setString( 2, wordPair.getRussianWord().getValue() );
            stmt.setBoolean( 3, unit.isLearned() );

            stmt.execute();
        } finally {
            if ( connection != null ) {
                connection.close();
            }
            if ( stmt != null ) {
                connection.close();
            }
        }
    }

    public void deleteUnit( int id ) throws SQLException {
        Connection connection = null;
        Statement stmt = null;

        @SuppressWarnings( "all" )
        String deleteSQL = "DELETE FROM" +
                " dictionary " +
                "WHERE id = " + id;
        try {
            connection = connectionProvider.getConnection();
            stmt = connection.createStatement();

            stmt.execute( deleteSQL );
        } finally {
            if ( connection != null ) {
                connection.close();
            }
            if ( stmt != null ) {
                connection.close();
            }
        }
    }

    public void updateUnit( int id, TrainingUnit unit ) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;

        @SuppressWarnings( "all" )
        String updateSQL = "UPDATE dictionary SET" +
                " ger_word = ?, rus_word = ?, learned = ? " +
                "WHERE id = " + id;
        try {
            connection = connectionProvider.getConnection();
            stmt = connection.prepareStatement( updateSQL );

            WordPair wordPair = unit.getWordPair();

            stmt.setString( 1, wordPair.getGermanWord().getValue() );
            stmt.setString( 2, wordPair.getRussianWord().getValue() );
            stmt.setBoolean( 3, unit.isLearned() );

            stmt.executeUpdate();
        } finally {
            if ( connection != null ) {
                connection.close();
            }
            if ( stmt != null ) {
                connection.close();
            }
        }
    }
}
