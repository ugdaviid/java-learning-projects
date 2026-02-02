import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UserManager manager = new UserManager();
        Scanner scanner = new Scanner(System.in);

        manager.loadUsers();

        while (true) {

            System.out.println("\n--- USER MANAGER ---");
            System.out.println("1. List users");
            System.out.println("2. Add user");
            System.out.println("3. Delete user");
            System.out.println("4. Find user");
            System.out.println("5. Save");
            System.out.println("0. Exit");

            System.out.print("Choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1 -> manager.listUsers();
                case 2 -> manager.addUser();
                case 3 -> manager.deleteUser();
                case 4 -> manager.findUser();
                case 5 -> manager.saveUsers();

                case 0 -> {
                    manager.saveUsers();
                    System.out.println("Bye!");
                    return;
                }

                default -> System.out.println("Invalid.");
            }
        }
    }
}
