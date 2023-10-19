package OOP.boom7;

import utils.Input;

public class Main {
  public static void game() {
    System.out.println("Please enter");
    Game game = new Game(Input.nextInt());
    int num;


    while (game.getCurrentPlayers() > 1) {
      System.out.println("Please say your number");
      num = Input.nextInt();
      if (game.need7() ? num != 7 : num != game.getLastNumber() + 1) {
        System.out.println('X');
        game.subPlayers();
      } else System.out.println("V");

      game.setLastNumber(game.getLastNumber() + 1);
    }

    System.out.println("The Last number was " + (game.getLastNumber() - 1));
  }

  public static void test() {
    Game game = new Game(2);

    for (int i = 0; i < 100; i++) {
      System.out.println(i + ": " + game.need7());
      game.setLastNumber(game.getLastNumber() + 1);
    }
  }
}
