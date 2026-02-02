public class ProgrammingBook extends Book implements Discount{

    public ProgrammingBook(int id, String title, String type, int price){
        super(id, title, type, price);
    }

    @Override
    public double getDiscountPrice() {
        return getPrice() * 0.8;
    }
}
