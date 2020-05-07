package fr.leroideskiwis.galacticdiscord.database;

public class ConnectionDataBuilder {

    private String host = "localhost";
    private String user = "root";
    private String password = "root";
    private String database = "database";
    private int port = 1433;

    public ConnectionDataBuilder withHost(String host){
        this.host = host;
        return this;
    }

    public ConnectionDataBuilder withUser(String user){
        this.user = user;
        return this;
    }

    public ConnectionDataBuilder withPassword(String password){
        this.password = password;
        return this;
    }

    public ConnectionDataBuilder withDatabase(String database){
        this.database = database;
        return this;
    }

    public ConnectionDataBuilder withport(int port){
        this.port = port;
        return this;
    }

    public ConnectionData build(){
        return new ConnectionData(host, port, database, user, password);
    }

}
