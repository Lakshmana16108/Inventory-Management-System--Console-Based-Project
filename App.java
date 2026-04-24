import Inventory.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Inventory inv = new Inventory();

        // Load existing products from file
        inv.loadProductsFromFile(); // from :contentReference[oaicite:0]{index=0}

        int choice;

        do {
            System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Supplier");
            System.out.println("2. Add Product");
            System.out.println("3. Display Products");
            System.out.println("4. Record Sale");
            System.out.println("5. Show Low Stock");
            System.out.println("6. Update Stock");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Supplier ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    System.out.print("Enter Supplier Name: ");
                    String sname = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    Supplier s = new Supplier(sid, sname, phone); // :contentReference[oaicite:1]{index=1}
                    inv.addSupplier(s);
                    System.out.println("Supplier added!");
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String pname = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    System.out.print("Enter Supplier ID: ");
                    int psid = sc.nextInt();

                    Product p = new Product(pid, pname, price, qty, psid); // :contentReference[oaicite:2]{index=2}
                    inv.addProduct(p);
                    System.out.println("Product added!");
                    break;

                case 3:
                    System.out.println("\n--- Product List ---");
                    inv.displayProducts();
                    break;

                case 4:
                    System.out.print("Enter Sale ID: ");
                    int saleId = sc.nextInt();

                    System.out.print("Enter Product ID: ");
                    int spid = sc.nextInt();

                    System.out.print("Enter Quantity: ");
                    int sqty = sc.nextInt();

                    inv.recordSale(saleId, spid, sqty); // :contentReference[oaicite:3]{index=3}
                    break;

                case 5:
                    inv.showLowStock();
                    break;

                case 6:
                    System.out.print("Enter Product ID: ");
                    int upid = sc.nextInt();

                    System.out.print("Enter New Quantity: ");
                    int newQty = sc.nextInt();

                    inv.updateStock(upid, newQty); // :contentReference[oaicite:4]{index=4}
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}