import java.io.*;
import java.util.*;

public class UserManager implements Manager {

    private List<User> users = new ArrayList<>();
    private final String FILE_NAME = "users.txt";
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void loadUsers() {

        users.clear();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);

                users.add(new User(id, name, age));
            }

        } catch (IOException e) {
            System.out.println("No file found.");
        }
    }

    @Override
    public void saveUsers() {

        try (FileWriter writer = new FileWriter(FILE_NAME)) {

            for (User u : users) {
                writer.write(
                        u.getId() + "," +
                                u.getName() + "," +
                                u.getAge() + "\n"
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUser() {

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();

        users.add(new User(id, name, age));

        System.out.println("User added.");
    }

    @Override
    public void deleteUser() {

        System.out.print("ID to delete: ");
        int id = scanner.nextInt();

        users.removeIf(u -> u.getId() == id);

        System.out.println("Deleted if existed.");
    }

    @Override
    public void findUser() {

        System.out.print("Name: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        for (User u : users) {

            if (u.getName().equalsIgnoreCase(name)) {
                System.out.println(u);
                return;
            }
        }

        System.out.println("Not found.");
    }

    @Override
    public void listUsers() {

        for (User u : users) {
            System.out.println(u);
        }
    }
}
