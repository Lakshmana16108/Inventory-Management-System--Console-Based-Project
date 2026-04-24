package Inventory;

public class Sale {
    private int saleId;
    private int productId;
    private int qty;
    private double total;

    public Sale(int saleId, int productId, int qty, double total) {
        this.saleId = saleId;
        this.productId = productId;
        this.qty = qty;
        this.total = total;
    }

    public String toFileString() {
        return saleId + "," + productId + "," + qty + "," + total;
    }

    public void displaySale() {
        System.out.println("SaleID: " + saleId +
                " ProductID: " + productId +
                " Qty: " + qty +
                " Total: " + total);
    }
}