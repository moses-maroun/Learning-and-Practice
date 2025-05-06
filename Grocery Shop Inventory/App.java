import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<GroceryItem> inventory = new ArrayList<>();
        
        inventory.add(new GroceryItem("Apple", 10, 0.5));
        inventory.add(new GroceryItem("Banana", 20, 0.3));
        inventory.add(new GroceryItem("Orange", 15, 0.4));
        inventory.add(new GroceryItem("Milk", 5, 1.2));
        GroceryShop shop = new GroceryShop(inventory);
        Scanner scan= new Scanner(System.in);
        int n=0;
        do{System.out.println("Hello, Welcome to our Grocery Shop!\nHow can I help you?" 
                            + "\n1-Find and Buy items\n2-Generate receipt\n3-Exit\nSelect: ");
        n = scan.nextInt();
        if(n==1) {
            System.out.println("Finding items...");
            shop.readCustomerShoppingList();
            shop.processItems();
        }
        else if(n==2) {
            System.out.println("Generating receipt...");
            shop.generateReceipt("Receipt.txt");
        }
        else if(n==3) {
            System.out.println("Come Back!!\nExiting...");
        }
        else {
            System.out.println("Invalid option. Please try again.");

        }
        }while(n!=3);
        scan.close();
    }
}

