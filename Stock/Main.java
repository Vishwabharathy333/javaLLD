package Stock;

import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StockMarket system = new StockMarket();

        while(true){
            System.out.println("""
            1. Add product
            2. Update stock
            3. Search Product
            4. Record Sale
            5. Record Purchase
            6. Low Stock Record
            7. sales Report
            8. Purchase Report
            9.Update Product Details
            10.exit""");
            int choice = sc.nextInt();
            sc.nextLine();

            try{
                switch(choice){
                    case 1:
                        System.out.println("Enter the ProductId, Product, Category, Quantity, Price, SupplierName: ");
                        system.addProduct(new Product(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.next()));
                        break;
                    case 2:
                        System.out.println("Enter the productId, Quantity: ");
                        system.updateStock(sc.next(), sc.nextInt());
                        break;
                    case 3:
                        System.out.println("Enter the Keyword: ");
                        system.search(sc.next());
                        break;
                    case 4:
                        System.out.println("Enter the productId, Quantity: ");
                        system.recordTransaction(sc.next(), "SALE", sc.nextInt());
                        break;
                    case 5:
                        System.out.println("Enter the productId,Quantity: ");
                        system.recordTransaction(sc.next(), "PURCHASE", sc.nextInt());
                        break;
                    case 6:
                        System.out.println("Enter Threshold: ");
                        system.lowStockReport(sc.nextInt());
                        break;
                    case 7:
                        system.salesReport();
                        break;
                    case 8:
                        system.purchaseReport();
                        break;
                    case 9:
                        System.out.println("Enter the productId, Product, Category, SupplierName, Price: ");
                        system.updateProductDetails(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble());
                        break;
                    case 10:
                        System.out.println("Exiting...");
                        return;
                }
            }catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
