import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        manager.loadTasks();

        while (true) {

            System.out.println("\n--- TASK MANAGER ---");
            System.out.println("1. Add task");
            System.out.println("2. List all");
            System.out.println("3. Mark done");
            System.out.println("4. Check date");
            System.out.println("5. Show statistics");
            System.out.println("6. Save tasks");
            System.out.println("0. Exit");

            System.out.print("Choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1 -> manager.addTask();
                case 2 -> manager.listAll();
                case 3 -> manager.markDone();
                case 4 -> manager.listOverdueTasks();
                case 5 -> manager.showStatistics();
                case 6 -> manager.saveTasks();

                case 0 -> {
                    manager.saveTasks();
                    System.out.println("Bye.");
                    return;
                }

                default -> System.out.println("Invalid.");
            }
        }
    }
}
