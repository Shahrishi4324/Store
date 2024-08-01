package Store;

public class Books extends item{
    private int pages; 
    Books(){
        super();
        this.pages = 0;
    }

    Books(int stockNumber, String name, int stock, int pages){
        super(stockNumber, name, stock);
        this.pages = pages;
    }
    int getPages(){
        return this.pages;
    }
    
}
