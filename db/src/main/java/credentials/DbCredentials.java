package credentials;

public abstract class DbCredentials {
    protected String user;
    protected String password;
    protected String connectString;


    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getConnectString() {
        return connectString;
    }

    public void setUser( String user ) {
        this.user = user;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public void setConnectString( String connectString ) {
        this.connectString = connectString;
    }
}
