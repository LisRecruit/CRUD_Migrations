package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    public static void main(String[] args) {
        printAllProjects();
        checkProjectDates();

//        try {
//            System.out.println(DatabaseQueryService.findLongestProject());
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
}
    public static void printAllProjects() {
        String query = "SELECT * FROM project";

        try (Connection connection = Database.getConnetction();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("ID");
                Long clientId = resultSet.getLong("CLIENT_ID");
                java.sql.Date startDate = resultSet.getDate("START_DATE");
                java.sql.Date finishDate = resultSet.getDate("FINISH_DATE");

                System.out.println("Project ID: " + id);
                System.out.println("Client ID: " + clientId);
                System.out.println("Start Date: " + startDate);
                System.out.println("Finish Date: " + finishDate);
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void checkProjectDates() {
        String query = "SELECT ID, CLIENT_ID, START_DATE, FINISH_DATE FROM project";

        try (Connection connection = Database.getConnetction();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Checking project dates:");
            while (resultSet.next()) {
                Long id = resultSet.getLong("ID");
                Long clientId = resultSet.getLong("CLIENT_ID");
                java.sql.Date startDate = resultSet.getDate("START_DATE");
                java.sql.Date finishDate = resultSet.getDate("FINISH_DATE");

                // Вывод значений для диагностики
                System.out.printf("Project ID: %d | Client ID: %d | Start Date: %s | Finish Date: %s%n",
                        id, clientId, startDate, finishDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

