package OOP.dominos;

import java.util.Random;

public class Domino {
  private int num1;
  private int num2;

  public Domino() {
    Random r = new Random();
    this.num1 = r.nextInt(1, 7);
    this.num2 = r.nextInt(1, 7);
  }

  public int getNum1() {
    return num1;
  }

  public void setNum1(byte num1) {
    this.num1 = num1;
  }

  public int getNum2() {
    return num2;
  }

  public void setNum2(byte num2) {
    this.num2 = num2;
  }
}
