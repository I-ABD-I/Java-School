package OOP.parking;

import utils.Input;

public class Main {
  public static void parking() {
    Park park = new Park();
    char input = 0;
    char floor;

    while (input != 'F') {
      switch (input) {
        case 'I' -> {
          if (park.getFloorA() > 0) {
            System.out.println("Floor A");
            park.setFloorA(park.getFloorA() + 1);
          } else if (park.getFloorB() > 0) {
            System.out.println("Floor B");
            park.setFloorB(park.getFloorB() + 1);
          } else System.out.println("Full");
        }
        case 'O' -> {
          floor = Input.nextChar();
          switch (floor) {
            case 'A' -> park.setFloorA(park.getFloorA() - 1);
            case 'B' -> park.setFloorB(park.getFloorB() - 1);
          }
        }
      }
      System.out.println("Please enter I O or F");
      input = Input.nextChar();
    }
    System.out.println(
      "The total amount of cars parking is " + (100 - park.getFloorB() + 100 - park.getFloorA()));
  }

}
