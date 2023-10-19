package OOP.couples;

public class Couple {
  private int num1;
  private int num2;

  public Couple(int num1, int num2) {
    this.num1 = num1;
    this.num2 = num2;
  }

  public boolean equals(Couple couple) {
    if (couple != null)
      return this.num1 == couple.num1 && this.num2 == couple.num2;
    return false;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Couple)
      return equals((Couple) obj);
    return false;
  }

  public int getNum1() {
    return num1;
  }

  public void setNum1(int num1) {
    this.num1 = num1;
  }

  public int getNum2() {
    return num2;
  }

  public void setNum2(int num2) {
    this.num2 = num2;
  }

  @Override
  public String toString() {
    return "Couple{" +
      "num1=" + num1 +
      ", num2=" + num2 +
      '}';
  }
}
