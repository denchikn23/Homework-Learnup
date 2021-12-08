package learnup;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/mysystem";
    private static final String DB_USER = "postgres";
    private static final String DB_PASS = "postgres";
    private static DbHelper helper = new DbHelper(DB_URL, DB_USER, DB_PASS);

    public static void main(String[] args){
        try {
            Class.forName("org.postgresql.Driver");
            addManager();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printAllManager(){
        for (Integer day : helper.getAllDaysAndSteps().keySet()){
            System.out.println("StepsManager{day=" + day + ", " + "steps=" + helper.getAllDaysAndSteps().get(day) +"}");
        }
    }

    private static void addDayStepsAndPrintAll(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите номер нового дня...");
            final int day = parseInt(scanner.nextLine());
            System.out.println("Введите количество шагов...");
            final int steps = parseInt(scanner.nextLine());
            helper.addDayAndSteps(day, steps);
            printAllManager();
        }
    }

    private static void deleteDayAndPrintAll(){
        printAllManager();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите номер для удаления...");
            final int day = parseInt(scanner.nextLine());
            helper.deleteDay(day);
            printAllManager();
        }
    }

    private static void addManager(){
        StepsManager actualManager = new StepsManager();

        actualManager.add(5, 30);
        actualManager.add(2, 10);
        actualManager.add(2, 40);
        actualManager.add(1, 40);
        actualManager.add(3, 10);
        actualManager.add(7, 40);
        actualManager.add(9, 60);

        helper.addStepsManager(actualManager.getStat());
        printAllManager();
    }
}
