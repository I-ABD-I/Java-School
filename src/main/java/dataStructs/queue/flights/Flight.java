package dataStructs.queue.flights;

import utils.Queue;
import utils.QueueUtils;

public class Flight {
    private int price;
    private int flightNumber;
    private final int capacity;
    private int passengers;
    private Queue<Traveler> accepted;
    private Queue<Traveler> onHold;

    public Flight(int price, int flightNumber, int capacity) {
        this.price = price;
        this.flightNumber = flightNumber;
        this.capacity = capacity;
        this.passengers = 0;
        this.accepted = new Queue<Traveler>();
        this.onHold = new Queue<Traveler>();
    }

    public void addTraveler(Traveler traveler) {
        if (this.passengers < this.capacity) {
            this.accepted.insert(traveler);
            this.passengers++;
        } else {
            this.onHold.insert(traveler);
        }
    }

    public void putOnHold(Traveler traveler) {
        Queue<Traveler> temp = new Queue<Traveler>();
        while (!this.accepted.isEmpty()) {
            temp.insert(this.accepted.remove());
        }

        while (!temp.isEmpty()) {
            Traveler current = temp.remove();
            if (!current.equals(traveler)) {
                this.accepted.insert(current);
            } else {
                this.passengers--;
                this.onHold.insert(current);
            }
        }
    }

    public void removeTraveler(Traveler traveler) {
        Queue<Traveler> temp = new Queue<Traveler>();
        while (!this.onHold.isEmpty()) {
            temp.insert(this.onHold.remove());
        }

        while (!temp.isEmpty()) {
            Traveler current = temp.remove();
            if (!current.equals(traveler))
                this.onHold.insert(current);
        }
    }

    public boolean isInQueues(String id) {
        Queue<Traveler> temp = QueueUtils.copy(this.accepted);
        while (!temp.isEmpty()) {
            if (temp.remove().getId().equals(id))
                return true;
        }

        temp = QueueUtils.copy(this.onHold);
        while (!temp.isEmpty()) {
            if (temp.remove().getId().equals(id))
                return true;
        }
        return false;

    }

    public double paidPresent() {
        double count = 0;

        Queue<Traveler> temp = QueueUtils.copy(this.accepted);
        while (!temp.isEmpty()) {
            Traveler current = temp.remove();
            if (current.getPricePaid() >= this.price)
                count++;
        }

        return (count / this.passengers) * 100;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public Queue<Traveler> getAccepted() {
        return accepted;
    }

    public void setAccepted(Queue<Traveler> accepted) {
        this.accepted = accepted;
    }

    public Queue<Traveler> getOnHold() {
        return onHold;
    }

    public void setOnHold(Queue<Traveler> onHold) {
        this.onHold = onHold;
    }

}
