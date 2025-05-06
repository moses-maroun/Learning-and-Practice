import java.util.*;
import java.io.*;

public class GroceryShop {
    ArrayList<GroceryItem> items = new ArrayList<GroceryItem>();
    ArrayList<GroceryItem> items2 = new ArrayList<GroceryItem>();
    ArrayList<GroceryItem> inventory = new ArrayList<GroceryItem>();
    public GroceryShop(ArrayList<GroceryItem> inventory){
        this.inventory = inventory;
    }
    
    
    public ArrayList<GroceryItem> readCustomerShoppingList() throws FileNotFoundException{
        Scanner scan = new Scanner(new File("ShoppingList.txt"));
        
        while (scan.hasNextLine()) {
              String name = scan.next();             
              int quantity = scan.nextInt();                       
              GroceryItem item2 = new GroceryItem(name, quantity);
              items.add(item2);
        }
        
        scan.close();
        return items;
    }
    public void processItems(){
        int n=0;
        for(GroceryItem item : items) {
            for(GroceryItem inventoryItem : inventory) {
                if(item.getName().equals(inventoryItem.getName()) && item.getStockQuantity() <= inventoryItem.getStockQuantity()) {
                    System.out.println("Item: " + item.getName() + " is available in stock.");
                    item.setPrice(inventoryItem.getPrice());
                    items2.add(item);
                    inventoryItem.updateStock(item.getStockQuantity());
                    break;
                } 
                else{
                    n++;
                }
            }
            if (n==inventory.size()) {
               System.out.println("Item: " + item.getName() + " is not available in stock.");
            }
        }
    }
    public void generateReceipt(String fileName) throws IOException {
        int total = 0;
        double totalPrice = 0.0;
        FileWriter w= new FileWriter(new File(fileName));
        PrintWriter pw = new PrintWriter(w);
        for(GroceryItem item : items2) {
            pw.println("Item: " + item.getName());
            pw.println("Price: " + item.getPrice());
            pw.println("Quantity: " + item.getStockQuantity());
            total += item.getStockQuantity();
            totalPrice += item.getPrice() * item.getStockQuantity();
        }
        pw.println("Total items: " + total);
        pw.println("Total price: " + totalPrice);
        pw.close();
    }
}
