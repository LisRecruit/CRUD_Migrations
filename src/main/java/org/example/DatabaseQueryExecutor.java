package org.example;


public class DatabaseQueryExecutor {
        private static final String SEPARATOR = "_____________";
    public static void main(String[] args) {
            DatabaseQueryService.findLongestProject();
            System.out.println(SEPARATOR);
            DatabaseQueryService.findClientWithMaxProjects();
            System.out.println(SEPARATOR);
            DatabaseQueryService.findWorkerWithMaxSalary();
            System.out.println(SEPARATOR);
            DatabaseQueryService.findYoungestOldesWorkers();
            System.out.println(SEPARATOR);
            DatabaseQueryService.printProjectPrices();
            System.out.println(SEPARATOR);
    }

}

