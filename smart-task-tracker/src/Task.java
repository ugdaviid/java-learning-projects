import java.time.LocalDate;

public class Task {

    private int id;
    private String title;
    private Priority priority;
    private Status status;
    private LocalDate deadline;

    public Task(int id, String title, Priority priority, Status status, LocalDate deadline){
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.status = status;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString(){
        return id + " | " + title + " | " + priority + " | " + status + " | " + deadline;
    }

}
