package OOP.cars;

public class Car {
  private final String company;
  private final String model;
  private final String id;
  private int owners;
  private double price;

  public Car(String company, String model, String id, double price, int owners) {
    this.company = company;
    this.model = model;
    this.id = id;
    this.price = price;
    this.owners = owners;
  }

  public int getOwners() {
    return owners;
  }

  public void setOwners(int owners) {
    this.owners = owners;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void sellCar() {
    owners++;
  }

  @Override
  public String toString() {
    return "Car{" + "company='" + company + '\'' + ", model='" + model + '\'' + ", id='" + id + '\''
           + ", price=" + price + ", owners=" + owners + '}';
  }
}
