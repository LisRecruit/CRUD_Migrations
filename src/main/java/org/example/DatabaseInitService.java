package org.example;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        try (Connection connection = Database.getConnetction();
             Statement statement = connection.createStatement()) {
            String initDb = DatabaseTools.readSqlFile("sql/init_db.sql");
            statement.execute(initDb);
            System.out.println("Database initialized successfully.");
            System.out.println("Executing SQL: " + initDb);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}


