public class NovelBook extends Book implements Discount{

    public NovelBook(int id, String title, String type, int price){
        super(id, title, type, price);
    }

    @Override
    public double getDiscountPrice(){
        return getPrice() * 0.9;
    }

}
