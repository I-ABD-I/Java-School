package OOP.cubes;

import utils.Input;

public class Main {
  public static void largestRolls() {
    CubeGame cube;

    System.out.println("Enter player names");
    cube = new CubeGame(Input.nextLine(), Input.nextLine());

    for (int i = 0; i < 20; i++) {
      cube.roll();
    }

    if (cube.getDice1() == cube.getDice2()) System.out.println("Both Got Same Score!");
    else if (cube.getDice1() > cube.getDice2()) System.out.println(cube.getPlayer1() + " Won");
    else System.out.println(cube.getPlayer2() + " Won");

  }
}
