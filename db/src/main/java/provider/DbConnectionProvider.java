package provider;

import credentials.DbCredentials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionProvider {
    private DbCredentials dbCredentials;

    public DbConnectionProvider( DbCredentials dbCredentials ) {
        this.dbCredentials = dbCredentials;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection( dbCredentials.getConnectString(),
                dbCredentials.getUser(), dbCredentials.getPassword() );
    }
}
