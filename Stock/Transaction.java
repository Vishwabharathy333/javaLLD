package Stock;

import java.util.*;
import java.time.LocalDate;

class Transaction{
    private static int counter = 1;
    private int transactionId;
    private String productId;
    private String type;
    private int quantity;
    private LocalDate date;

    public Transaction(String productId, String type, int quantity){
        this.transactionId = counter++;
        this.productId = productId;
        this.type = type;
        this.quantity = quantity;
        this.date = LocalDate.now();
    }

    public int getTransactionId(){ return transactionId; }
    public String getProductId(){ return productId; }
    public String getType(){ return type; }
    public int getQuantity(){ return quantity; }

    @Override
    public String toString(){
        return "TxnId: " + transactionId +
                "| Product: " + productId +
                "| Type: " + type +
                "| Quantity: " + quantity +
                "| Date: " + date;
    }
}
