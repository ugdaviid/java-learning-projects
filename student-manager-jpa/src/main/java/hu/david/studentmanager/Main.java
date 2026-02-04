package hu.david.studentmanager;

import hu.david.studentmanager.dao.StudentDAO;
import hu.david.studentmanager.model.Student;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add");
            System.out.println("2. List");
            System.out.println("3. Find by id");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("0. Exit");

            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    dao.save(new Student(name, age, email));
                }

                case 2 -> dao.findAll().forEach(System.out::println);

                case 3 -> {
                    System.out.print("ID: ");
                    long id = scanner.nextInt();

                    System.out.println(dao.findById(id));
                }

                case 4 -> {
                    System.out.print("ID: ");
                    long id = scanner.nextLong();
                    scanner.nextLine();

                    Student s = dao.findById(id);

                    if (s != null) {

                        System.out.print("New name: ");
                        s.setName(scanner.nextLine());

                        dao.update(s);
                    }
                }

                case 5 -> {
                    System.out.print("ID: ");
                    long id = scanner.nextLong();

                    dao.delete(id);
                }

                case 0 -> {
                    System.out.println("Bye");
                    System.exit(0);
                }
            }
        }
    }
}
