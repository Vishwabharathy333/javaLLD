import java.util.*;

class TicketSystem{
    private final List<String> availableBerths = new ArrayList<>(Arrays.asList("L","U","M"));
    private final Queue<Passenger> racQueue = new LinkedList<>();
    private final Queue<Passenger> waitingListQueue = new LinkedList<>();
    private final List<Passenger> confirmedPassengers = new ArrayList<>();
    private int ticketCounter = 1;

    public String allocateBerth(int age, String gender, String berthPreference){
        if ((age >= 60 || gender.equalsIgnoreCase("female")) && availableBerths.contains("L")){
            return "L";
        }if(availableBerths.contains(berthPreference)){
            return berthPreference;
        }
        return availableBerths.get(0);
    }

    public void bookTicket(String name, int age, String gender, String berthPreference){
        String ticketId = "T-" + ticketCounter++;
        Passenger passenger;
        if(!availableBerths.isEmpty()){
            String allocatedBerth = allocateBerth(age, gender, berthPreference);
            passenger = new Passenger(name, age, gender, berthPreference, allocatedBerth, ticketId);
            confirmedPassengers.add(passenger);
            availableBerths.remove(allocatedBerth);
            System.out.println("Ticket Confirmed " + passenger);
        } else if (racQueue.size() < 1){
            passenger = new Passenger(name, age, gender, berthPreference, "RAC", ticketId);
            racQueue.offer(passenger);
            System.out.println("Ticket in RAC " + passenger);
        }else if (waitingListQueue.size() < 1){
            passenger = new Passenger(name, age, gender, berthPreference, "Waiting List", ticketId);
            waitingListQueue.offer(passenger);
            System.out.println("Ticket in Waiting List");
        }else {
            System.out.println("No Tickets Available.");
        }
    }
    public void cancelTicket(String ticketId){
        Passenger found = null;
        for (Passenger p : confirmedPassengers){
            if (p.ticketId.equals(ticketId)){
                found = p;
                break;
            }
        }
        if (found != null){
            confirmedPassengers.remove(found);
            availableBerths.add(found.allotedberth);
            if(!racQueue.isEmpty()){
                Passenger racPassenger = racQueue.poll();
                String allocatedBerth = allocateBerth(racPassenger.age, racPassenger.gender, racPassenger.berthPreference);
                racPassenger.allocatedBerth = allocatedBerth;
                confirmedPassengers.add(racPassenger);
                availableBerths.remove(racPassenger.allocatedBerth);
                System.out.println("RAC Ticket moved to Confirm List " + racPassenger);
            }
            if (!waitingListQueue.isEmpty()){
                Passenger waitingPassenger = waitingListQueue.poll();
                waitingPassenger.allocatedBerth = "RAC";
                racQueue.offer(waitingPassenger);
                System.out.println("WaitingList Ticket moved to RAC " + waitingPassenger);
            }
            System.out.println("Ticket Successfully cancel for T-" + ticketId);
        }else{
            System.out.println("No ticket found with " + ticketId;)
        }
    }
    public void printBookedTickets(){
        if (confirmedPassengers.isEmpty()){
            System.out.println("No Confirmed tickets");
        }
        else{
            System.out.println("Confirmed Tickets: ");
            for (Passenger p : confirmedPassengers){
                System.out.println(p);
            }
        }
    }
    public void printAvailableTickets(){
        System.out.println("Available Berths: " + availableBerths.size());
        System.out.println("Available RAC Tickets :" + Math.abs(1 - (racQueue.size())));
        System.out.println("Available WaitingList Tickets :" + Math.abs(1 - (waitingListQueue.size())));
    }
    public void viewRacTickets(){
        if (!racQueue.isEmpty()){
            for (Passenger p : racQueue){
                System.out.println(p);
            }
        }else{
            System.out.println("No Tickets in RAC");
        }
    }
    public void viewWaitingListTickets(){
        if (!waitingListQueue.isEmpty()){
            for (Passenger p : waitingListQueue){
                System.out.println(p);
            }
        }else{
            System.out.println("No Tickets in RWaitingList.");
        }
    }
}
