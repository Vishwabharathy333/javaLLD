package Taxiii;

import java.util.*;

public class TaxiBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of taxis: ");
        int numTaxis = sc.nextInt();
        TaxiSystem system = new TaxiSystem(numTaxis);

        while (true) {
            System.out.println("\n1. Book Taxi\n2. Display Taxi Details\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the Pickup Point (A-F): ");
                    char from = sc.next().toUpperCase().charAt(0);
                    System.out.println("Enter the Drop Point (A-F): ");
                    char to = sc.next().toUpperCase().charAt(0);
                    System.out.println("Enter The PickupTime (in hour): ");
                    int pickupTime = sc.nextInt();
                    system.bookTaxi(from, to, pickupTime);
                    break;
                case 2:
                    system.displayTaxiDetails();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
