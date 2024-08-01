package Store;

import java.util.ArrayList;

public class inventory {
    ArrayList <item> items = new ArrayList <item>();
    void addItem(item newItem){
        items.add(newItem);
    }
    void discontinueItem(item item){
        item.discontinueItem(item);
    }
    void checkLowStock(item item){
        if (item.getStock() < 5){
            System.out.println("Low stock on " + item.getName());
        }
    }
    void getStock(item item){
        item.getStock();
    }
}
