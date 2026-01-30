package Taxiii;

import java.util.*;

class Taxi {
    private int id;
    private char currentPoint; // Initially all taxis start at point A
    private int totalEarnings;
    private List<Booking> bookings;

    public Taxi(int id){
        this.id = id;
        this.currentPoint = 'A';
        this.totalEarnings = 0;
        this.bookings = new ArrayList<>();
    }

    public boolean isAvailable(int requestTime) {
        if (bookings.isEmpty()) return true;
        Booking lastBooking = bookings.get(bookings.size() - 1);
        return lastBooking.getDropTime() <= requestTime;
    }

    public int calculateEarnings(char from, char to) {
        int distance = Math.abs(to - from) * 15;
        int amount = 100;
        if (distance > 5) {
        	amount += (distance - 5) * 10;
        }
        return amount;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
        totalEarnings += booking.getAmount();
        currentPoint = booking.getTo();
    }
    
    public char getCurrentPoint() {
    	return currentPoint;
    }
    
    public int getTotalEarnings() {
    	return totalEarnings;
    }

	public int getId() {
		return id;
	}
	
	public List<Booking> getBookings(){
		return Collections.unmodifiableList(bookings);
	}
	
	@Override
	public String toString() {
		return "Taxi-" + id + "| Point: " + currentPoint + "| Earning: " + totalEarnings;
	}
}
