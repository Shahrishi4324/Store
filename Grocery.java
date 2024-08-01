package Store;

public class Grocery extends item{
    private int expirationDate;
    Grocery(){
        super();
        this.expirationDate = 0;
    }
    Grocery(int stockNumber, String name, int stock, int expirationDate){
        super(stockNumber, name, stock);
        this.expirationDate = expirationDate;
    }
    int getExpirationDate(){
        return this.expirationDate;
    }
}
