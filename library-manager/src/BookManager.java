import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager implements Manager{

    private List<Book> books = new ArrayList<>();
    private final String FILE_NAME = "books.txt";
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void loadBooks(){

        books.clear();

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){

            String line;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String type = parts[2];
                int price = Integer.parseInt(parts[3]);

                books.add(new Book(id,title,type,price));
            }

        } catch (Exception e) {
            System.out.println("No file found.");
        }
    }

    @Override
    public void saveBooks(){
        try(FileWriter writer = new FileWriter(FILE_NAME)){

            for (Book b : books){
                writer.write(
                        b.getId() + "," +
                                b.getTitle() + "," +
                                b.getType() + "," +
                                b.getPrice() + "\n"
                );
            }

            writer.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void listBooks(){
        for (Book b : books){
            System.out.println(b);
        }
    }

    @Override
    public void findBook(){
        System.out.print("Title: ");
        String title = scanner.nextLine();

        for (Book b : books){
            if (b.getTitle().equalsIgnoreCase(title)){
                System.out.println(b);
            }
        }
    }

    @Override
    public void addBook(){
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Type: ");
        String type = scanner.nextLine();

        System.out.print("Price: ");
        int price = scanner.nextInt();

        books.add(new Book(id, title,type,price));

        System.out.println("Book added");
    }

    @Override
    public void updateBook(){
        System.out.print("ID: ");
        int id = scanner.nextInt();

        System.out.print("New price: ");
        int newPrice = scanner.nextInt();

        for (Book b : books){
            if (b.getId() == id){
                b.setPrice(newPrice);
            }
        }

        System.out.println("Updated.");
    }

    @Override
    public void deleteBook(){

        System.out.print("ID: ");
        int id = scanner.nextInt();

        books.removeIf(book -> book.getId() == id);

        System.out.println("Book deleted if existed");

    }

}
