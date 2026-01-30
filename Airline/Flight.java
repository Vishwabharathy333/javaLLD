package Airline;

import java.util.*;

class Flight{
    private String flightName;
    private int availableSeats;
    private int ticketPrice;
    private int bookingCounter;
    private Map<String, Passenger> bookings;

    public Flight(String flightName){
        this.flightName = flightName;
        this.availableSeats = 50;
        this.ticketPrice = 5000;
        this.bookings = new HashMap<>();
        this.bookingCounter = 0;
    }

    public String bookTickets(String name, int age, int seatsBooked){
    	if (seatsBooked <= 0) {
            System.out.println("Invalid seat count.");
            return null;
        }
        if (seatsBooked <= availableSeats){
            bookingCounter++;
            String bookingId = flightName.substring(0,2).toUpperCase() + "-" + bookingCounter;
            Passenger passenger = new Passenger(bookingId, name, age, seatsBooked);
            bookings.put(bookingId, passenger);
            availableSeats -= seatsBooked;
            ticketPrice += 200 * seatsBooked;
            return bookingId;
        }else{
            System.out.println("Booking failed, there is no Tickets. ");
            return null;
        }
    }

    public boolean cancelBooking(String bookingId){
        Passenger passenger = bookings.get(bookingId);
        if (passenger != null){
            int seats = passenger.getSeatsBooked();
            availableSeats += seats;
            ticketPrice -= 200 * seats;
            bookings.remove(bookingId);
            System.out.println("Booking canceled successfully. Refund issued for " + seats + " seats.");
            return true;
        }else {
            System.out.println("Cancellation failed: Booking ID not found.");
            return false;
        }
    }

    public void displayDetails(){
        System.out.println("Flight Name : " + flightName);
        System.out.println("Available Seats : " + availableSeats);
        System.out.println("Ticket Price : " + ticketPrice);
    }

    public void printDetails(){
        System.out.println("Flight Name : " + flightName);
        System.out.println("Available Seats : " + availableSeats);
        System.out.println("Ticket Price : " + ticketPrice);
        System.out.println("Passengers: ");
        for (Passenger p : bookings.values()){
            System.out.println(p);
        }
    }
}
