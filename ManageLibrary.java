package LibraryManage;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class ManageLibrary{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, LibraryItem> items = new HashMap<Integer, LibraryItem>();
        Stack<String> borrowingHistoryStack = new Stack<>();
        Queue bookReservationsQueue = new Queue(10);


        Book b1 = new Book("Rishi Shah", 98989, "Joy Shah");
        DVD d1 = new DVD("Friends", 123453, 120);

        items.put(b1.getItemID(), b1);
        items.put(d1.getItemID(), d1);
        
        System.out.println("Would you like to researve a Library Item: ");
        String response = sc.nextLine();
        response = response.toLowerCase();

        if (response.equals("yes")) {
            System.out.println("What is the item ID: ");
            int itemID = sc.nextInt();
            if (items.containsKey(itemID)) {
                LibraryItem selectedItem = items.get(itemID);
                // Enqueue user for book reservation
                bookReservationsQueue.enqueue(12); // Replace "User123" with the actual user
                System.out.println("You have been added to the reservation queue for " + selectedItem.getTitle());
                
                // Display borrowing history
                if (!selectedItem.isCheckedOut()) {
                    selectedItem.checkOut();
                    borrowingHistoryStack.push("User123 checked out " + selectedItem.getTitle());
                    System.out.println("You have successfully checked out " + selectedItem.getTitle());
                }

            } else {
                System.out.println("Sorry, this item does not exist");
            }
        }
        LibraryItem arr[] = new LibraryItem[2];
        arr[0] = b1;
        arr[1] = d1;
        for (LibraryItem item : arr) {
            item.displayInfo();
        }
        sc.close();
    }
}

abstract class LibraryItem{
    private String title;
    private int itemID;
    private boolean checkedOut;

    public LibraryItem(){
        title = "None";
        itemID = 0;
        checkedOut = false;
    }
    public LibraryItem(String title, int itemID){
        this.title = title;
        this.itemID = itemID;
        checkedOut = false;
    }
    public String getTitle(){
        return title;
    }
    public int getItemID(){
        return itemID;
    }
    public boolean isCheckedOut(){
        return checkedOut;
    }
    void checkOut(){
        checkedOut = true;
    }
    void returnItem(){
        checkedOut = false;
    }

    void displayInfo(){
        System.out.println("Title: " + title);
        System.out.println("Item ID: " + itemID);
        System.out.println("Checked Out: " + checkedOut);
    }

    boolean isOverDue(){
        return true; 
    }
}

class Book extends LibraryItem implements Reservable{
    private String author;
    Book(){
        super();
        author = "None";
    }
    Book(String title, int itemID, String author){
        super(title, itemID);
        this.author = author;
    }               
    public String getAuthor(){
        return author;
    }
    public void reserve(){
        System.out.println("Book reserved");
    }
    public void cancelReservation(){
        System.out.println("Book reservation cancelled");
    }
}

class DVD extends LibraryItem{
    private int duration;
    DVD(){
        super();
        duration = 0;
    }
    DVD(String title, int itemID, int duration){
        super(title, itemID);
        this.duration = duration;
    }
    public int getDuration(){
        return duration;
    }
}

class Queue {
    private int[] data;
    private int front, rear, max;

    public Queue(int maxItems) {
        data = new int[maxItems];
        front = -1;
        rear = -1;
        max = maxItems;
    }

    public int peek() {
        return data[front];
    }

    public int dequeue() {
        front = (front + 1) % max;
        return data[front - 1];
    }

    public void enqueue(int item) {
        if (empty()) {
            front = 0;
            rear = 0;
            data[rear] = item;
        } else {
            rear = (rear + 1) % max;
            data[rear] = item;
        }
    }

    public boolean empty() {
        return front == -1 && rear == -1;
    }

    public int size() {
        return empty() ? 0 : (rear - front + 1);
    }

    public void clear() {
        front = -1;
        rear = -1;
    }
}

interface Reservable{
    public void reserve();
    public void cancelReservation();
}