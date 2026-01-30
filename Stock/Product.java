package Stock;

import java.util.*;

class Product{
    private String productId;
    private String product;
    private String category;
    private int quantity;
    private double price;
    private String supplierName;

    public Product(String productId, String product, String category, int quantity, double price, String supplierName){
        this.productId = productId;
        this.product = product;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.supplierName = supplierName;
    }

    public String getProductId() { return productId; }
    public String getProduct() { return product; }
    public String getCategory() { return category; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public String getSupplierName() { return supplierName; }

    public void updateQuantity(int change){
        if ((quantity + change) < 0){
            throw new IllegalArgumentException("Insufficient Stock!");
        }
        quantity += change;
    }

    public void updateDetails(String product, String category, String supplierName, double price){
        this.product = product;
        this.category = category;
        this.supplierName = supplierName;
        this.price = price;
    }
    @Override
    public String toString(){
        return String.format(
            "ID: %s | Name: %s | Category: %s | Quantity: %s | Price: %s |Supplier: %s",
            productId, product, category, quantity,  price, supplierName);
    }
}
