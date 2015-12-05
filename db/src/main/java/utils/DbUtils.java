package utils;

import credentials.DbCredentials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
    public static Connection getConnection( DbCredentials dbCredentials ) throws SQLException {
        return DriverManager.getConnection( dbCredentials.getConnectString(),
                dbCredentials.getUser(), dbCredentials.getPassword() );
    }
}
