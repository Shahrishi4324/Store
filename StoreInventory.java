package Store;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreInventory {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        displayMainScreen();

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        inventory inv = new inventory();
        boolean play = true;
        int stockNumber;

        ArrayList <Electronics> electronics = new ArrayList <Electronics>();
        ArrayList <Books> books = new ArrayList <Books>();
        ArrayList <Grocery> groceries = new ArrayList <Grocery>();

        while(play){
            switch (choice){
                case 1:
                    System.out.println("What type of item would you like to add? ");
                    System.out.println("1. Electronics");
                    System.out.println("2. Books");
                    System.out.println("3. Grocery");
                    System.out.print("Enter your choice: ");
                    System.out.println("====================================");
                    int choice2 = sc.nextInt();
                    sc.nextLine();
                    switch(choice2){
                        case 1:
                            System.out.println("Enter the stock number: ");
                            stockNumber = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter the name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter the stock: ");
                            int stock = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter the warranty: ");
                            int warranty = sc.nextInt();
                            sc.nextLine();
                            Electronics newElectronics = new Electronics(stockNumber, name, stock, warranty);
                            electronics.add(newElectronics);
                            inv.addItem(newElectronics);
                            break;
                        case 2:
                            System.out.println("Enter the stock number: ");
                            stockNumber = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter the name: ");
                            String name2 = sc.nextLine();
                            System.out.print("Enter the stock: ");
                            int stock2 = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter the pages: ");
                            int pages = sc.nextInt();
                            sc.nextLine();
                            Books newBooks = new Books(stockNumber, name2, stock2, pages);
                            books.add(newBooks);
                            inv.addItem(newBooks);
                            break;
                        case 3:
                            System.out.println("Enter the stock number: ");
                            stockNumber = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter the name: ");
                            String name3 = sc.nextLine();
                            System.out.print("Enter the stock: ");
                            int stock3 = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter the expiration date: ");
                            int expirationDate = sc.nextInt();
                            sc.nextLine();
                            Grocery newGrocery = new Grocery(stockNumber, name3, stock3, expirationDate);
                            groceries.add(newGrocery);
                            inv.addItem(newGrocery);
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Enter the name of the item you wish to discontinue: ");
                    String discName = sc.nextLine();
                    for (int i = 0; i < inv.items.size(); i++){
                        if (inv.items.get(i).getName().equals(discName)){
                            inv.discontinueItem(inv.items.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter the name of the item you wish to see the stock of: ");
                    String stockName = sc.nextLine();
                    for (int i = 0; i < inv.items.size(); i++){
                        if (inv.items.get(i).getName().equals(stockName)){
                            inv.checkLowStock(inv.items.get(i));
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter the name of the item you wish to see the stock of: ");
                    String stockName2 = sc.nextLine();
                    for (int i = 0; i<inv.items.size(); i++){
                        if (inv.items.get(i).getName().equals(stockName2)){
                            System.out.println("The stock of " + stockName2 + " is " + inv.items.get(i).getStock());
                        }
                    }
                    break;
                case 5:
                    play = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
            break;
        }
        sc.close();
    }

    static void displayMainScreen(){
        System.out.println("Welcome to the store inventory system!");
        System.out.println("====================================");
        System.out.println("Main Menu: ");
        System.out.println("1. Add an item");
        System.out.println("2. Discontinue an item");
        System.out.println("3. Check low stock");
        System.out.println("4. Get stock");
        System.out.println("5. Quit");
        System.out.println("====================================");
    }
}
