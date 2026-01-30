package Taxiii;

import java.util.*;

class TaxiSystem{
    private int bookingCounter = 1;
    private int customerCounter = 1;
    private List<Taxi> taxis = new ArrayList<>();

    public TaxiSystem(int num){
        for (int i = 1; i <= num; i++){
            taxis.add(new Taxi(i));
        }
    }

    public void bookTaxi(char from, char to, int pickupTime){
        int customerId =customerCounter++;

        Taxi selectedTaxi = null;
        int minDistance = Integer.MAX_VALUE;

        for (Taxi taxi : taxis){
            if (taxi.isAvailable(pickupTime)){
                int distance = Math.abs(taxi.getCurrentPoint() - from);
                if (selectedTaxi == null || distance < minDistance || (distance == minDistance && taxi.getTotalEarnings() < selectedTaxi.getTotalEarnings())){
                    selectedTaxi = taxi;
                    minDistance = distance;
                }
            }
        }
        if (selectedTaxi == null){
            System.out.println("Booking rejected. No taxis available.");
            return;
        }
        int dropTime = pickupTime + Math.abs(to - from);
        int amount = selectedTaxi.calculateEarnings(from, to);
        int bookingId = bookingCounter++;

        Booking booking = new Booking(bookingId, customerId, from, to, pickupTime, dropTime, amount);
        selectedTaxi.addBooking(booking);
         System.out.println("Taxi-" + selectedTaxi.getId() + " is allocated.");
    }
    public void displayTaxiDetails() {
        for (Taxi taxi : taxis) {
            System.out.println("Taxi-" + taxi.getId() + " Total Earnings: Rs." + taxi.getTotalEarnings());
            System.out.printf("%-10s %-10s %-5s %-5s %-12s %-9s %-6s%n",
                    "BookingID", "CustomerID", "From", "To", "PickupTime", "DropTime", "Amount"); 
            for (Booking booking : taxi.getBookings()) {
                System.out.printf("%-10d %-10d %-5c %-5c %-12d %-9d %-6d%n",
                        booking.getBookingId(), booking.getCustomerId(), booking.getFrom(), booking.getTo(),
                        booking.getPickupTime(), booking.getDropTime(), booking.getAmount());
            }
        }
    }
}
