package dataStructs.queue.flights;

public class Main {
    public static void flightMain() {
        Flight flight = new Flight(1000, 1, 5);
        flight.addTraveler(new Traveler("Jhon", "0001", 100));
        flight.addTraveler(new Traveler("Doe", "0002", 100));
        flight.addTraveler(new Traveler("Smith", "0003", 100));
        flight.addTraveler(new Traveler("Brown", "0004", 1000));
        flight.addTraveler(new Traveler("Johnson", "0005", 1000));
        flight.addTraveler(new Traveler("hello", "0006", 1000));
        flight.putOnHold(new Traveler("Jhon", "0001", 100));
        flight.removeTraveler(new Traveler("Jhon", "0001", 100));

        System.out.println(flight.isInQueues("0001") + " expected false");
        System.out.println(flight.isInQueues("0002") + " expected true");

        System.out.println(flight.paidPresent() + " expected 50%");
        flight.putOnHold(new Traveler(null, "0004", 0));
        System.out.println(flight.paidPresent() + " expected 33%");
    }

    public static void main(String[] args) {
        flightMain();
    }

}
