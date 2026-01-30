package Taxiii;

class Booking {
    private int bookingId, customerId, pickupTime, dropTime, amount;
    private char from, to;

    public Booking(int bookingId, int customerId, char from, char to, int pickupTime, int dropTime, int amount) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.from = from;
        this.to = to;
        this.pickupTime = pickupTime;
        this.dropTime = dropTime;
        this.amount = amount;
    }
    
    public int getBookingId() { return bookingId; }
    public int getCustomerId() { return customerId; }
    public int getPickupTime() {return pickupTime; }
    public char getFrom() { return from; }
    public int getDropTime() { return dropTime; }
    public int getAmount() { return amount; }
    public char getTo() { return to; }
    
    @Override
    public String toString() {
        return bookingId + "   " +
               customerId + "   " +
               from + " -> " + to + "   " +
               pickupTime + "   " +
               dropTime + "   Rs." + amount;
    }
}
