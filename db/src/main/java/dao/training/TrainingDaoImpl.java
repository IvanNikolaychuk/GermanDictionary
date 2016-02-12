package dao.training;

import dictionary.training.TrainingUnit;
import dictionary.word.WordPair;
import provider.DbConnectionProvider;
import utils.TrainingDaoUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainingDaoImpl implements TrainingDao {
    private DbConnectionProvider connectionProvider;

    public TrainingDaoImpl( DbConnectionProvider connectionProvider ) {
        this.connectionProvider = connectionProvider;
    }

    public void insertUnit( TrainingUnit unit ) throws SQLException {
        @SuppressWarnings( "all" )
        final String insertSQL =
                "INSERT INTO " +
                        "dictionary(ger_word, rus_word, correct_answers) " +
                        "VALUES (?,?,?)";

        try ( Connection conn = connectionProvider.getConnection();
              PreparedStatement stmt = conn.prepareStatement( insertSQL ) ) {

            WordPair wordPair = unit.getWordPair();

            stmt.setString( 1, wordPair.getGermanWord().getValue() );
            stmt.setString( 2, wordPair.getRussianWord().getValue() );
            stmt.setInt( 3, unit.getCorrectAnswers() );

            stmt.execute();
        }
    }

    public void deleteUnit( int id ) throws SQLException {

        @SuppressWarnings( "all" )
        final String deleteSQL =
                "DELETE FROM " +
                        "dictionary " +
                        "WHERE id = " + id;

        try ( Connection conn = connectionProvider.getConnection();
              Statement stmt = conn.createStatement() ) {

            stmt.execute( deleteSQL );
        }
    }

    public boolean deleteUnit( String gerWord ) throws SQLException {

        @SuppressWarnings( "all" )
        final String deleteSQL =
                "DELETE FROM " +
                        "dictionary " +
                        "WHERE ger_word = '" + gerWord + "'";

        try ( Connection conn = connectionProvider.getConnection();
              Statement stmt = conn.createStatement() ) {

            return stmt.execute( deleteSQL );
        }
    }

    public void updateUnit( int id, TrainingUnit unit ) throws SQLException {

        @SuppressWarnings( "all" )
        final String updateSQL =
                "UPDATE dictionary SET " +
                        "ger_word = ?, rus_word = ?, correct_answers = ? " +
                        "WHERE id = " + id;

        try ( Connection conn = connectionProvider.getConnection();
              PreparedStatement stmt = conn.prepareStatement( updateSQL ) ) {

            WordPair wordPair = unit.getWordPair();

            stmt.setString( 1, wordPair.getGermanWord().getValue() );
            stmt.setString( 2, wordPair.getRussianWord().getValue() );
            stmt.setInt( 3, unit.getCorrectAnswers() );

            stmt.executeUpdate();
        }
    }

    public List<TrainingUnit> getUnits( int maxUnits ) throws SQLException {
        List<TrainingUnit> trainingUnits = new ArrayList<>( maxUnits );

        @SuppressWarnings( "all" )
        final String selectSQL = "SELECT * " +
                "FROM dictionary " +
                "LIMIT " + maxUnits;

        try ( Connection conn = connectionProvider.getConnection();
              Statement stmt = conn.createStatement();
              ResultSet rs = stmt.executeQuery( selectSQL ) ) {

            while ( rs.next() ) {
                trainingUnits.add( TrainingDaoUtils.generateUnitFromResultSet( rs ) );
            }
        }

        return trainingUnits;
    }

    public List<TrainingUnit> getAllUnits() throws SQLException {
        List<TrainingUnit> trainingUnits = new ArrayList<>();

        @SuppressWarnings( "all" )
        final String selectSQL = "SELECT * " +
                "FROM dictionary";

        try ( Connection conn = connectionProvider.getConnection();
              Statement stmt = conn.createStatement();
              ResultSet rs = stmt.executeQuery( selectSQL ) ) {

            while ( rs.next() ) {
                trainingUnits.add( TrainingDaoUtils.generateUnitFromResultSet( rs ) );
            }
        }

        return trainingUnits;
    }

    public TrainingUnit getUnit( int id ) throws SQLException {

        @SuppressWarnings( "all" )
        final String selectSQL =
                "SELECT * " +
                        "FROM dictionary " +
                        "WHERE id = " + id;

        try ( Connection conn = connectionProvider.getConnection();
              Statement stmt = conn.createStatement();
              ResultSet rs = stmt.executeQuery( selectSQL ) ) {

            // assume there is one unit with such id.
            // move rs to point on first one.
            rs.next();
            TrainingUnit unit = TrainingDaoUtils.generateUnitFromResultSet( rs );

            if ( unit == null ) {
                // todo: make normal exceptions
                throw new SQLException( "No unit with id " + id );
            }

            return unit;
        }
    }


}
