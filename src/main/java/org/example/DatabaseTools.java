package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DatabaseTools {
    public static String readSqlFile(String filePath) throws IOException {
        StringBuilder sql = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sql.append(line).append("\n");
            }
        }
        return sql.toString();
    }
}
