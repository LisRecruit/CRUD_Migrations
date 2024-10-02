package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {


    public static void main(String[] args) {
        try (Connection connection = Database.getConnetction()) {
            String initDb = DatabaseTools.readSqlFile("sql/populate_db.sql");
            try (PreparedStatement preparedStatement = connection.prepareStatement(initDb)) {
                preparedStatement.executeUpdate();
            }
            System.out.println("Database fulfilled successfully.");
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
