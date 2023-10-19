package OOP.cubes;

import java.util.Random;

public class CubeGame {
  private String player1;
  private int dice1;
  private String player2;
  private int dice2;

  public CubeGame(String player1, String player2) {
    this.player1 = player1;
    this.player2 = player2;
  }

  private void rollDice1() {
    int r = new Random().nextInt(1, 7);
    dice1 += r;
    System.out.println("Player 1 got Number" + r);
  }

  private void rollDice2() {
    int r = new Random().nextInt(1, 7);
    dice2 += r;
    System.out.println("Player 2 got Number" + r);
  }

  public void roll() {
    rollDice1();
    rollDice2();
  }

  @Override
  public String toString() {
    return "CubeGame{" + "player1='" + player1 + '\'' + ", dice1=" + dice1 + ", player2='" + player2
           + '\'' + ", dice2=" + dice2 + '}';
  }

  public String getPlayer1() {
    return player1;
  }

  public void setPlayer1(String player1) {
    this.player1 = player1;
  }

  public int getDice1() {
    return dice1;
  }

  public void setDice1(int dice1) {
    this.dice1 = dice1;
  }

  public String getPlayer2() {
    return player2;
  }

  public void setPlayer2(String player2) {
    this.player2 = player2;
  }

  public int getDice2() {
    return dice2;
  }

  public void setDice2(int dice2) {
    this.dice2 = dice2;
  }
}
