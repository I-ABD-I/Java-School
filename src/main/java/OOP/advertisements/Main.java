package OOP.advertisements;

import utils.Input;

public class Main {
  public static int advertOfCompany(Advertisement[] ads, String company) {
    int total = 0;
    for (var ad : ads) {
      if (ad.getCompany().equals(company)) total += ad.getLength();
    }
    return total;
  }

  public static void ads() {
    Advertisement[] ads = new Advertisement[53];

    for (int i = 0; i < ads.length; i++) {
      System.out.println("Please enter name, company, length");
      ads[i] = new Advertisement(Input.nextLine(), Input.nextLine(), Input.nextInt());
    }

    int totalPrice = 0;
    for (var ad : ads) {
      System.out.println(
        "Time: " + ad.getTime() + "Price: " + ad.getLength() * Advertisement.price);
      totalPrice += ad.getLength() * Advertisement.price;
    }

    System.out.println("Total Price: " + totalPrice);

    int maxPrice = 0;
    String maxCompany = null;
    for (var ad : ads) {
      if (advertOfCompany(ads, ad.getCompany()) > maxPrice) {
        maxPrice = advertOfCompany(ads, ad.getCompany());
        maxCompany = ad.getCompany();
      }
    }

    System.out.println("The company that paid the most is: " + maxCompany);
  }

  public static void test(Advertisement ad) {
    System.out.println(ad.getTime());
  }
}
