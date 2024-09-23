package org.example;


import org.example.tableObjects.Project;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DatabaseQueryService {

    public static List<Project> findLongestProject() throws SQLException {
        Connection connection = Database.getConnetction();
        List<Project> result = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(DatabaseTools.readSqlFile("sql/find_longest_project.sql"));
            while (resultSet.next()){
                java.sql.Date startDate = resultSet.getDate("START_DATE");
                java.sql.Date finishDate = resultSet.getDate("FINISH_DATE");
                if (startDate != null && finishDate != null) {

                    LocalDate localStartDate = startDate.toLocalDate();
                    LocalDate localFinishDate = finishDate.toLocalDate();

                    result.add(Project.builder()

                            .id(resultSet.getObject("ID", Long.class))
                            .clientId(resultSet.getObject("CLIENT_ID", Long.class))
//                        .startDate(resultSet.getObject("START_DATE", LocalDate.class))
                            .startDate(localStartDate)
//                        .finishDate(resultSet.getObject("FINISH_DATE", LocalDate.class))
                            .finishDate(localFinishDate)
                            .build());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    public void findClientWithMaxProjects() throws SQLException{
        Connection connection = Database.getConnetction();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(DatabaseTools.readSqlFile("sql/find_max_projects_client.sql"));
            while (resultSet.next()){
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

