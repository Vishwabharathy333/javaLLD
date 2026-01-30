package Airline;

import java.util.*;

class FlightReservationSystem{
    private Map<String, Flight> flights;

    public FlightReservationSystem(){
        flights = new HashMap<>();
        flights.put("Indigo", new Flight("Indigo"));
        flights.put("Spicejet", new Flight("Spicejet"));
    }

    public String bookTicket(String flightName, String name, int age, int seatsBooked){
        Flight flight = flights.get(flightName);
        if (flight != null){
            return flight.bookTickets(name, age, seatsBooked);
        }
        else{
            System.out.println("Booking failed: Flight not found.");
            return null;
        }
    }

    public boolean cancelTicket(String flightName, String bookingId){
        Flight flight = flights.get(flightName);
        if (flight != null){
            return flight.cancelBooking(bookingId);
        }else{
            System.out.println("Cancellation Failed. Flight Name is not found.");
            return false;
        }
    }

    public void displayFlightDetails(String flightName){
        Flight flight = flights.get(flightName);
        if (flight != null){
            flight.displayDetails();
        }else{
            System.out.println("Flight not found");
        }
    }

    public void printFlightDetails(String flightName){
        Flight flight = flights.get(flightName);
        if (flight != null){
            flight.printDetails();
        }else{
            System.out.println("Flight not found: ");
        }
    }
    
    public boolean isFlightAvailable(String flightName) {
        return flights.containsKey(flightName);
    }
}
