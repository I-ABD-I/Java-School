package OOP.cars;

import utils.Input;

public class Main {
  public static void canBuyCar() {
    double budget;

    System.out.println("Please enter company, model, id, price, owners");
    Car car1 = new Car(Input.nextLine(),
                       Input.nextLine(),
                       Input.nextLine(),
                       Input.nextDouble(),
                       Input.nextInt());

    System.out.println("Please enter a budget");
    budget = Input.nextDouble();

    if (budget > car1.getPrice()) {
      System.out.println("Can buy car");
      car1.sellCar();
      System.out.println(car1);
    } else {
      System.out.println("Cannot Buy Car Missing: " + (car1.getPrice() - budget) + "$");
    }
  }

  public static void sellCheapestCar(Car c1, Car c2) {
    if (c1.getPrice() < c2.getPrice() && c1.getOwners() <= 2) {
      c1.sellCar();
      System.out.println(c1);
    } else if (c2.getOwners() <= 2) {
      c2.sellCar();
      System.out.println(c2);
    } else System.out.println("no car sold");
  }

  // ex15 output (Car):
  // Car{company='Toyota', model='Corolla', id='2331234', price=87000.0, owners=1}
  // sold: Car{company='Toyota', model='Corolla', id='2331234', price=82650.0, owners=2}


}
