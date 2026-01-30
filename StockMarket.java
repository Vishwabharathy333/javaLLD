package Stock;

import java.util.*;
import java.util.stream.Collectors;

class StockMarket{
    private Map<String, Product> inventory = new HashMap<>();
    private List<Transaction> transactions = new ArrayList<>();

    public void addProduct(Product product){
        if (inventory.containsKey(product.getProductId())){
            throw new IllegalArgumentException("Product Id is already Exist!");
        }
        inventory.put(product.getProductId(), product);
    }
    public void updateStock(String productId, int quantity){
        Product p = getProductName(productId);
        p.updateQuantity(quantity);
    }   
    private Product getProductName(String id){
        if (!inventory.containsKey(id)){
            throw new IllegalArgumentException("Product not found.");
        }
        return inventory.get(id);
    }
    public void search(String keyword){
        inventory.values().stream()
            .filter(p -> 
                p.getProductId().equalsIgnoreCase(keyword) ||
                p.getProduct().equalsIgnoreCase(keyword) ||
                p.getCategory().equalsIgnoreCase(keyword))
            .forEach(System.out::println);
    }

    public void recordTransaction(String productId, String type, int quantity){
        Product p = getProductName(productId);
        if (type.equalsIgnoreCase("SALE")){
            p.updateQuantity(-quantity);
        }else{
            p.updateQuantity(quantity);
        }
        Transaction transaction = new Transaction(productId,type,quantity);
        transactions.add(transaction);
    }
    public void lowStockReport(int threshold){
        inventory.values().stream()
            .filter(p -> p.getQuantity() < threshold)
            .forEach(System.out::println);
    }

    public void salesReport(){
        transactions.stream()
            .filter(t -> t.getType().equalsIgnoreCase("SALE"))
            .collect(Collectors.groupingBy(
                Transaction::getProductId,
                Collectors.summingInt(Transaction::getQuantity)))
            .forEach((k,v) -> System.out.println(k + " sold: " + v));
    }

    public void purchaseReport(){
        transactions.stream()
            .filter(t -> t.getType().equalsIgnoreCase("PURCHASE"))
            .collect(Collectors.groupingBy(
                Transaction::getProductId,
                Collectors.summingInt(Transaction::getQuantity)))
            .forEach((k,v) -> System.out.println(k + " Purchase: " + v));
    }

    public void updateProductDetails(String id, String product,String category, String supplierName, double price){
        Product p = getProductName(id);
        p.updateDetails(product,category,supplierName,price);
    }
}
