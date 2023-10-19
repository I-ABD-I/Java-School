package OOP.jumpers;

import utils.Input;

public class Main {
  public static void jumps() {
    Jumper jumper;
    int amount;
    int totalRecords = 0;
    double totalJumps = 0;

    System.out.println("Please enter jumper ID");
    jumper = new Jumper(Input.nextLine());

    System.out.println("Please enter the amount of jumps");
    amount = Input.nextInt();

    for (int i = 0; i < amount; i++) {
      System.out.println("Please enter jump");
      totalRecords += jumper.updateJumps(Input.nextDouble());
      totalJumps += jumper.getJump1();
    }

    System.out.println("The Jump Avg is " + totalJumps / amount);
    if (totalRecords >= amount / 2) System.out.println("Good Job!");
    else System.out.println("Continue Training");
  }

}
