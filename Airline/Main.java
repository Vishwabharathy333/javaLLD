package Airline;

import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        FlightReservationSystem system = new FlightReservationSystem();

        while(true){
            System.out.println("---Flight Ticket Reservation---");
            System.out.println("\n1. Book Ticket \n2. Cancel Ticket \n3. Print Flight Details \n4. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Enter the Flight Name: ");
                    String flightName = sc.nextLine();
                    if (system.isFlightAvailable(flightName)){
                        system.displayFlightDetails(flightName);
                        System.out.println("Enter the Passenger Name: ");
                        String name = sc.nextLine();
                        System.out.println("Enter the Passenger Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter tha No. of Seats you wants to Book: ");
                        int seatsBooked = sc.nextInt();
                        sc.nextLine();
                        String bookingId = system.bookTicket(flightName, name, age, seatsBooked);
                        if (bookingId != null){
                            System.out.println("Booking successful! Your booking ID is: " + bookingId);
                        }
                    }else{
                            System.out.println("Invalid flight name. Please try again.");
                    }
                    break;
                case 2:
                    System.out.println("Enter the Flight Name: ");
                    flightName = sc.nextLine();
                    if (!system.isFlightAvailable(flightName)) {
                    	System.out.println("Flight Name is invalid.");
                    	break;
                    }
                    System.out.println("Enter the Booking Id: ");
                    String bookingId = sc.nextLine();
                    system.cancelTicket(flightName, bookingId);
                    break;
                case 3:
                    System.out.println("Enter the Flight Name: ");
                    flightName = sc.nextLine();
                    system.printFlightDetails(flightName);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Option. Try again.");
            }
        }
    }
}
