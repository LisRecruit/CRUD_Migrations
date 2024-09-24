package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {


    public static void main(String[] args) {
        try (Connection connection = Database.getConnetction();
             Statement statement = connection.createStatement()) {
            String initDb = DatabaseTools.readSqlFile("sql/populate_db.sql");
            statement.execute(initDb);
            System.out.println("Database fulfilled successfully.");
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
