package Inventory;
public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private int supplierId;

    public Product(int id, String name, double price, int quantity, int supplierId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.supplierId = supplierId;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public int getSupplierId() { return supplierId; }

    public void addStock(int q) {
        quantity += q;
    }

    public boolean reduceStock(int q) {
        if (quantity >= q) {
            quantity -= q;
            return true;
        }
        return false;
    }

    public void displayProduct() {
        System.out.println(id + " | " + name + " | Price: " + price + " | Qty: " + quantity);
    }
}