package Inventory;
import java.util.*;
import java.io.*;

public class Inventory {

    private ArrayList<Supplier> suppliers = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Sale> sales = new ArrayList<>();

    private final String PRODUCT_FILE = "products.txt";
    public void loadProductsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(PRODUCT_FILE))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                int id = Integer.parseInt(d[0]);
                String name = d[1];
                double price = Double.parseDouble(d[2]);
                int qty = Integer.parseInt(d[3]);
                int sid = Integer.parseInt(d[4]);

                products.add(new Product(id, name, price, qty, sid));
            }
        } catch (IOException e) {
            System.out.println("No previous data found.");
        }
    }
    private void saveProductsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PRODUCT_FILE))) {
            for (Product p : products) {
                bw.write(p.getId() + "," + p.getName() + "," +
                         p.getPrice() + "," + p.getQuantity() + "," + p.getSupplierId());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
    public void addSupplier(Supplier s) {
        suppliers.add(s);
    }

    public void addProduct(Product p) {
        products.add(p);
        saveProductsToFile();
    }
    public Product findProduct(int id) {
        for (Product p : products) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }
    public void displayProducts() {
        for (Product p : products) {
            p.displayProduct();
        }
    }
    public void recordSale(int saleId, int productId, int qty) {
        Product p = findProduct(productId);

        if (p != null && p.reduceStock(qty)) {
            double total = qty * p.getPrice();
            sales.add(new Sale(saleId, productId, qty, total));

            saveProductsToFile(); // update stock in file
            System.out.println("Sale Done!");
        } else {
            System.out.println("Not enough stock!");
        }
    }
    public void showLowStock() {
        int f=0;
        System.out.println("Low Stock Products:");
        for (Product p : products) {
            if (p.getQuantity() < 5) {
                p.displayProduct();
            }
            else {
                f=1;
            }
        }
        if(f==1) {
            System.out.println("=====No Low Stock Products Available=====");
        }
    }
    public void updateStock(int productId, int newQty) {
        Product p = findProduct(productId);

        if (p != null) {
            int currentQty = p.getQuantity();

            if (newQty >= 0) {
                int diff = newQty - currentQty;

                if (diff > 0)
                    p.addStock(diff);
                else if (diff < 0)
                    p.reduceStock(-diff);

                saveProductsToFile();
                System.out.println("Stock updated successfully!");
            } else {
                System.out.println("Invalid quantity!");
            }
        } else {
            System.out.println("Product not found!");
        }
    }
}