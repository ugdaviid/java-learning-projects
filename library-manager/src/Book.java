public class Book {

    private int id;
    private String title;
    private String type;
    private int price;

    public Book(int id, String title, String type, int price){
        this.id = id;
        this.title = title;
        this.type = type;
        this.price = price;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return id + " | " + title + " | " + type + " | " + price;
    }
}
