import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {

    private List<Task> tasks = new ArrayList<>();
    private final String FILE_NAME = "tasks.txt";
    private Scanner scanner = new Scanner(System.in);

    public void addTask(){

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Title:");
        String title = scanner.nextLine();

        System.out.print("Priority (LOW/HIGH/MEDIUM): ");
        String pr = scanner.nextLine().toUpperCase();

        System.out.print("Deadline (YYYY-MM-DD): ");
        String d = scanner.nextLine();
        LocalDate deadline = LocalDate.parse(d);

        Priority priority = Priority.valueOf(pr);



        Task task = new Task(id, title, priority, Status.TODO, deadline);

        tasks.add(task);

        System.out.println("Task added.");
    }

    public void listAll(){
        for (Task t : tasks){
            System.out.println(t);
        }
    }

    public void markDone(){
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Task t : tasks){
            if (t.getId() == id){
                t.setStatus(Status.DONE);
                System.out.println("Marked as DONE");
                return;
            }
        }
        System.out.println("Not found.");
    }

    public void listOverdueTasks() {

        LocalDate today = LocalDate.now();

        for (Task t : tasks){

            if (t.getDeadline().isBefore(today)
                    && t.getStatus() != Status.DONE){

                System.out.println("LEJÁRT: " + t);

            }
            else if (t.getDeadline().isBefore(today.plusDays(3))
                    && t.getStatus() != Status.DONE){

                System.out.println("KÖZELGŐ: " + t);
            }
        }
    }

    public void showStatistics(){

        int countTask = 0;
        int countHigh = 0;
        int countExpired = 0;
        int countDone = 0;

        for (Task t : tasks){

            countTask++;

            if (t.getPriority() == Priority.HIGH){
                countHigh++;
            }

            if (t.getStatus() == Status.DONE){
                countDone++;
            }

            if (t.getDeadline().isBefore(LocalDate.now())
                    && t.getStatus() != Status.DONE){

                countExpired++;
            }
        }

        double percentDone = 0;

        if (countTask > 0){
            percentDone = (double) countDone / countTask * 100;
        }

        System.out.println("Total tasks: " + countTask);
        System.out.println("Done: " + countDone + " (" + percentDone + "%)");
        System.out.println("High priority: " + countHigh);
        System.out.println("Expired: " + countExpired);
    }

    public void loadTasks(){

        tasks.clear();

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){

            String line;

            while ((line = reader.readLine()) != null){
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                Priority priority = Priority.valueOf(parts[2]);
                Status status = Status.valueOf(parts[3]);
                LocalDate deadline = LocalDate.parse(parts[4]);

                tasks.add(new Task(id, title, priority, status, deadline));
            }

        } catch (IOException e) {
            System.out.println("No file found.");
        }

    }

    public void saveTasks(){

        try(FileWriter writer = new FileWriter(FILE_NAME)){

            for (Task t : tasks){
                writer.write(
                                t.getId()+ "," +
                                    t.getTitle() + "," +
                                    t.getPriority() + "," +
                                    t.getStatus() + "," +
                                    t.getDeadline() + "\n"
                        );
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }


}
