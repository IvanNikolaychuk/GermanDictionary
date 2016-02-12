package dao.settings;

import provider.DbConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SettingsDao {
    private DbConnectionProvider connectionProvider;

    public SettingsDao( DbConnectionProvider connectionProvider ) {
        this.connectionProvider = connectionProvider;
    }

    //todo: implement this
    public void setDeleteWordOnCorrectAnswers( int numberOfAnswers ) throws SQLException {
        final String updateSQL =
                "UPDATE settings SET " +
                        "correct_answers_for_deleting_pair = " + numberOfAnswers + " WHERE id = 1";

        try ( Connection conn = connectionProvider.getConnection(); ) {
            conn.createStatement().execute( updateSQL );
        }
    }

    public int getDeleteWordOnCorrectAnswersVal() throws SQLException {

        String selectQuery = "SELECT * " +
                "FROM settings " +
                "LIMIT " + 1;

        try ( Connection conn = connectionProvider.getConnection(); ) {
            ResultSet rs = conn.createStatement().executeQuery( selectQuery );
            // only one value, skipping
            rs.next();
            return rs.getInt( "correct_answers_for_deleting_pair" );
        }
    }


}
