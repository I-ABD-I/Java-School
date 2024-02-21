package dataStructs.queue.flights;

public class Traveler {
    private String name;
    private String id;
    private double pricePaid;

    public boolean equals(Traveler other) {
        return this.id.equals(other.id);
    }

    public Traveler(String name, String id, double pricePaid) {
        this.name = name;
        this.id = id;
        this.pricePaid = pricePaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(double pricePaid) {
        this.pricePaid = pricePaid;
    }

}
