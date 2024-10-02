package org.example;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInitService {

    public static void main(String[] args) {

        try (Connection connection = Database.getConnetction()) {
            String initDb = DatabaseTools.readSqlFile("sql/init_db.sql");
            try (PreparedStatement preparedStatement = connection.prepareStatement(initDb)) {
                preparedStatement.execute();
            }
            System.out.println("Database initialized successfully.");
            System.out.println("Executing SQL: " + initDb);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}


