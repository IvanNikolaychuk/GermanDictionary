package credentials;

import java.io.IOException;

//todo: make secure
public class PostgresCredentials extends DbCredentials {
    private static PostgresCredentials instance;

    private PostgresCredentials() {
    }

    public static PostgresCredentials getInstance() throws IOException {
        if ( instance == null ) {
            instance = new PostgresCredentials();
        }

        return instance;
    }


}
