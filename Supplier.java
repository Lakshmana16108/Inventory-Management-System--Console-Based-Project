package Inventory;

public class Supplier extends Person {
    private int supplierId;

    public Supplier(int supplierId, String name, String phone) {
        super(name, phone);
        this.supplierId = supplierId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void displaySupplier() {
        System.out.print("Supplier ID: " + supplierId + ", ");
        displayPerson();
    }
}