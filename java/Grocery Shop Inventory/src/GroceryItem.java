public class GroceryItem implements InventoryItem {
    private String name;
    private int stockQuantity;
    private double price;

    public GroceryItem(String name, int stockQuantity, double price){
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.price = price;
    }
    public GroceryItem(String name, int stockQuantity){
        this.name = name;
        price = 0.0;
        this.stockQuantity = stockQuantity;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
        
    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }
        
    @Override
    public int getStockQuantity(){
        return stockQuantity;
    }
    @Override
    public void updateStock(int quantity){
        stockQuantity -= quantity;
    }
} 
    

