package fr.leroideskiwis.galacticdiscord.database;

import java.sql.*;

public class Database {

    private Connection connection;
    private Statement statement;

    public Database(ConnectionData connectionData) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://"+connectionData.host+"/"+connectionData.database+"?autoReconnect=true", connectionData.user, connectionData.password);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        return statement.executeQuery(sql);
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    public boolean hasNext(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean hasNext = resultSet.next();
        resultSet.close();
        return hasNext;
    }

    public void close(){
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
