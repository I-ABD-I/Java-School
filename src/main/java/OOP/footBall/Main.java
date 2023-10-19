package OOP.footBall;

import utils.Input;

public class Main {
  public static void footBallSeason() {
    FootBallTeam team;
    int state;

    System.out.println("Please enter a team name");
    team = new FootBallTeam(Input.nextLine());

    for (int i = 0; i < 30; i++) {
      System.out.println("Please enter game state");
      state = Input.nextInt();

      switch (state) {
        case 0 -> team.draw();
        case 1 -> team.win();
        case 2 -> team.lose();
      }
    }

    if (team.getGamesWon() < team.getGamesLost() + team.getGamesDraw()) team.setLeague("National");

    System.out.println(team);
  }


}
