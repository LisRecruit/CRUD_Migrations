package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import  java.sql.DriverManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Statement;

public class DatabasePopulateService {


    public static void main(String[] args) {
        try (Connection connection = Database.getConnetction();
             Statement statement = connection.createStatement()) {
            System.out.println("_____");
            String init_db = DatabaseTools.readSqlFile("sql/populate_db.sql");
            statement.execute(init_db);
            System.out.println("Database fulfilled successfully.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("++++++");
    }

}
