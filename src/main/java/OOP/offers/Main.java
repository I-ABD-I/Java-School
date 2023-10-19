package OOP.offers;

import utils.Input;

public class Main {
  public static void bestOffer() {
    Offer[] offers = new Offer[3];
    for (int i = 0; i < offers.length; i++) {
      System.out.println("Please enter name, amount");
      offers[i] = new Offer(Input.nextLine(), Input.nextInt());
    }

    if (offers[0].getAmount() > offers[1].getAmount()
        && offers[0].getAmount() > offers[2].getAmount())
      System.out.println("Best Offer is: " + offers[0]);
    else if (offers[1].getAmount() > offers[2].getAmount())
      System.out.println("Best Offer is: " + offers[1]);
    else System.out.println("Best Offer is: " + offers[2]);
  }
}
