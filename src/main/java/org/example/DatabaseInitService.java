package org.example;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        try (Connection connection = Database.getConnetction();
             Statement statement = connection.createStatement()) {
            System.out.println("_____");

            String init_db = DatabaseTools.readSqlFile("sql/init_db.sql");
            statement.execute(init_db);
            System.out.println("Database initialized successfully.");

            System.out.println("Executing SQL: " + init_db);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.println("++++++");

    }



}


