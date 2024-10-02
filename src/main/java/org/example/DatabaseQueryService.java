package org.example;


import lombok.SneakyThrows;
import org.example.table_objects.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DatabaseQueryService {
    @SneakyThrows
    public static List<Project> findLongestProject() {
        Connection connection = Database.getConnetction();
        List<Project> result = new ArrayList<>();
        String initDb = DatabaseTools.readSqlFile("sql/find_longest_project.sql");
        try (PreparedStatement preparedStatement = connection.prepareStatement(initDb)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                java.sql.Date startDate = resultSet.getDate("START_DATE");
                java.sql.Date finishDate = resultSet.getDate("FINISH_DATE");
                if (startDate != null && finishDate != null) {
                    LocalDate localStartDate = startDate.toLocalDate();
                    LocalDate localFinishDate = finishDate.toLocalDate();
                    result.add(Project.builder()
                            .id(resultSet.getObject("ID", Long.class))
                            .clientId(resultSet.getObject("CLIENT_ID", Long.class))
                            .startDate(localStartDate)
                            .finishDate(localFinishDate)
                            .build());
                }
            }
            result.forEach(System.out::println);
        }
        return result;
    }

    @SneakyThrows
    public static void findClientWithMaxProjects() {
        Connection connection = Database.getConnetction();
        List<Client> result = new ArrayList<>();
        String initDb = DatabaseTools.readSqlFile("sql/find_max_projects_client.sql");
        try (PreparedStatement preparedStatement = connection.prepareStatement(initDb)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long projectCount = resultSet.getObject("project_count", Long.class);
                result.add(Client.builder()
                        .id(resultSet.getObject("ID", Long.class))
                        .name(resultSet.getObject("NAME", String.class))
                        .build());
                result.forEach(project -> System.out.println(project + "Projects count: " + projectCount));
            }
        }
    }

    @SneakyThrows
    public static void findWorkerWithMaxSalary() {
        Connection connection = Database.getConnetction();
        List<Worker> result = new ArrayList<>();
        String initDb = DatabaseTools.readSqlFile("sql/find_max_salary_worker.sql");
        try (PreparedStatement preparedStatement = connection.prepareStatement(initDb)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                java.sql.Date birthDate = resultSet.getDate("BIRTHDAY");
                LocalDate localBirthDate = birthDate.toLocalDate();
                String levelString = resultSet.getObject("LEVEL", String.class).toUpperCase();
                WorkerLevel level = null;
                if (levelString != null) {
                    level = WorkerLevel.valueOf(levelString);
                }
                result.add(Worker.builder()
                        .id(resultSet.getObject("ID", Long.class))
                        .name(resultSet.getObject("NAME", String.class))
                        .birthday(localBirthDate)
                        .level(level)
                        .salary(resultSet.getObject("SALARY", Integer.class))
                        .build()
                );
            }
            result.forEach(System.out::println);
        }
    }

    @SneakyThrows
    public static void findYoungestOldesWorkers() {
        Connection connection = Database.getConnetction();
        List<Worker> result = new ArrayList<>();
        String initDb = DatabaseTools.readSqlFile("sql/find_youngest_eldest_workers.sql");
        try (PreparedStatement preparedStatement = connection.prepareStatement(initDb)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String type = resultSet.getString("TYPE");
                String name = resultSet.getString("NAME");
                java.sql.Date birthDate = resultSet.getDate("BIRTHDAY");
                LocalDate localBirthDate = birthDate != null ? birthDate.toLocalDate() : null;
                Worker worker = Worker.builder()
                        .name(name)
                        .birthday(localBirthDate)
                        .build();
                result.add(worker);
                System.out.println(type + ": " + worker.getName() + ", Birthday: " + worker.getBirthday());
            }
        }
    }

    @SneakyThrows
    public static void printProjectPrices() {
        Connection connection = Database.getConnetction();
        List<ProjectCost> result = new ArrayList<>();
        String initDb = DatabaseTools.readSqlFile("sql/print_project_prices.sql");
        try (PreparedStatement preparedStatement = connection.prepareStatement(initDb)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(ProjectCost.builder()
                        .projectId(resultSet.getObject("ID", Long.class))
                        .clientId(resultSet.getObject("CLIENT_ID", Long.class))
                        .cost(resultSet.getObject("project_cost", Double.class))
                        .build()
                );
            }
            result.forEach(System.out::println);
        }
    }
}

