import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        BookManager manager = new BookManager();

        manager.loadBooks();

        while (true){
        System.out.println("--- Library Manager ---");
        System.out.println("1. List Books");
        System.out.println("2. Find Books");
        System.out.println("3. Add Books");
        System.out.println("4. Update Books");
        System.out.println("5. Delete Books");
        System.out.println("6. Save Books");
        System.out.println("0. Exit");


            System.out.print("Choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> manager.listBooks();
                case 2 -> manager.findBook();
                case 3 -> manager.addBook();
                case 4 -> manager.updateBook();
                case 5 -> manager.deleteBook();
                case 6 -> manager.saveBooks();
                case 0 -> {
                    manager.saveBooks();
                    System.out.println("Bye");
                    return;
                }

                default -> System.out.println("Invalid");
            }
    }


















        /*final String FILE_NAME = "books.txt";
        List<Book> books = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){

            String line;

            while ((line = reader.readLine()) != null){
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String type = parts[2];
                int price = Integer.parseInt(parts[3]);

                books.add(new Book(id, title, type, price));

                if (type.equalsIgnoreCase("NOVEL")){
                    NovelBook n = new NovelBook(id, title, type, price);
                    System.out.println(n.getTitle() + " (" + n.getType() + ")"  + " " + n.getPrice() + " -> " + n.getDiscountPrice());
                }

                if (type.equalsIgnoreCase("PROGRAMMING")){
                    ProgrammingBook p = new ProgrammingBook(id,title,type,price);
                    System.out.println(p.getTitle() + " (" + p.getType() + ")" + " " + p.getPrice() + " -> " + p.getDiscountPrice());
                }
            }

        } catch (IOException e) {
            System.out.println("No file found.");
        }

        System.out.println("\n");
        double fullPrice = 0;
        double avgPrice = 0;
        for (Book b : books){
            fullPrice += b.getPrice();
            avgPrice = fullPrice / books.size();
        }

        System.out.println(avgPrice);

    }*/
    }
}