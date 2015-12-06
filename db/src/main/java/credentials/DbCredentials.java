package credentials;

import com.sun.media.sound.InvalidDataException;

import java.io.IOException;

import static utils.Const.*;
import static utils.Const.COLON;
import static utils.Const.SEPARATOR;

public abstract class DbCredentials {
    protected String user;
    protected String password;
    protected String connectString;
    protected String host;
    protected String port;
    protected String db;

    /**
     * Should be called after
     * <p>port</p>
     * <p>host</p>
     * <p>db</p>
     * are injected
     * @throws InvalidDataException
     */
    protected void generateAndInitConnString() throws InvalidDataException {
        if ( host == null || port == null || db == null ) {
            try {
                init();
            } catch ( IOException e ) {
                e.printStackTrace();
            }
            throw new InvalidDataException( "db, host and port should be initialized" );
        }
        connectString = CONNECTION_JDBC + COLON + DB_PG_TYPE +
                COLON + SEPARATOR_DOUBLE + host + COLON + port +
                SEPARATOR + db;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getConnectString() {
        return connectString;
    }

    /**
     * All concrete DbCredential classes are planed to be singletons.
     * init method is called to read all credentials
     */
    abstract public void init() throws IOException;
}
