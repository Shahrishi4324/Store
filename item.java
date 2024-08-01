package Store;

public class item {
    private int stockNumber;
    private String name;
    private int stock;
    item(){
        this.stockNumber = 0;
        this.name = "none";
        this.stock = 0;
    }
    item(int stockNumber, String name, int stock){
        this.stockNumber = stockNumber;
        this.name = name;
        this.stock = stock;
    }
    void discontinueItem(item discItem){
        this.name = "discontinued";
        this.stock = 0; 
    }
    int getStock(){
        return this.stock;
    }
    String getName(){
        return this.name;
    }
    int getStockNumber(){
        return this.stockNumber;
    }
}
