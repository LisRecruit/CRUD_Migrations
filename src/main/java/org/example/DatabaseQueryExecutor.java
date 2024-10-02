package org.example;


public class DatabaseQueryExecutor {
        private static final String SEPARATOR = "_____________";
    public static void main(String[] args) {
        System.out.println("Longest projects are:");
        DatabaseQueryService.findLongestProject();
        System.out.println(SEPARATOR);
        System.out.println("Client(s) with max projects:");
        DatabaseQueryService.findClientWithMaxProjects();
        System.out.println(SEPARATOR);
        System.out.println("Worker(s) with max salary:");
        DatabaseQueryService.findWorkerWithMaxSalary();
        System.out.println(SEPARATOR);
        System.out.println("Youngest and oldest workers are:");
        DatabaseQueryService.findYoungestOldesWorkers();
        System.out.println(SEPARATOR);
        System.out.println("Project prices are:");
        DatabaseQueryService.printProjectPrices();
        System.out.println(SEPARATOR);
    }
}

