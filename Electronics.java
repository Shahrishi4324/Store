package Store;

public class Electronics extends item{
    private int warranty; 
    Electronics(){
        super();
        this.warranty = 0;
    }
    Electronics(int stockNumber, String name, int stock, int warranty){
        super(stockNumber, name, stock);
        this.warranty = warranty;
    }
    int getWarranty(){
        return this.warranty;
    }
}   
