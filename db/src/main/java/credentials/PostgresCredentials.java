package credentials;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//todo: make secure
public class PostgresCredentials extends DbCredentials {
    private static PostgresCredentials instance;



    private PostgresCredentials() {
    }

    public static PostgresCredentials getInstance() throws IOException {
        if ( instance == null ) {
            instance = new PostgresCredentials();
            instance.init();
        }

        return instance;
    }

    // todo : rewrite exception and way to get credentials
    public void init() throws IOException {
        Properties prop = new Properties();
        prop.load( new FileInputStream( Properties.class.getResource( "/" ).getPath() + "db-config.properties" ) );
        String host = prop.getProperty( "host" );
        String port = prop.getProperty( "port" );
        String user = prop.getProperty( "user" );
        String password = prop.getProperty( "password" );
        String db = prop.getProperty( "db" );

        super.host = host;
        super.port = port;
        super.user = user;
        super.password = password;
        super.db = db;
        generateAndInitConnString();
    }

}
