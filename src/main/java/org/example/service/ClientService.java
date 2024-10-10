package org.example.table_objects;

import org.example.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientService {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 1000;

    Connection connection;

    {
        try {
            connection = Database.getConnetction();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public long create (String name){

    }

    public String getById(long id) throws SQLException {
        String sql = "SELECT NAME FROM client WHERE ID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString("NAME");
            } else {
                throw new SQLException("Client with ID " + id + " not found.");
            }
        }
    }


}
