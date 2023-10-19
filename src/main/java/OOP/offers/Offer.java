package OOP.offers;

public class Offer {
  private final String name;
  private final double amount;

  public Offer(String name, double amount) {
    this.name = name;
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "Offer{" + "name='" + name + '\'' + ", amount=" + amount + '}';
  }

  public String getName() {
    return name;
  }

  public double getAmount() {
    return amount;
  }
}
