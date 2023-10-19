package OOP.camping;

public class MultiCamp {
  private String name;
  private int num1;
  private int num2;

  public MultiCamp(String name) {
    this.name = name;
    num1 = 0;
    num2 = 0;
  }

  public void insertKid(int age) {
    if (8 <= age && age <= 11) num1++;
    else if (12 <= age && age <= 15) num2++;
  }

  public boolean hasSpace() {
    return num1 + num2 < 100;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "MultiCamp{" + "name='" + name + '\'' + ", num1=" + num1 + ", num2=" + num2 + '}';
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
}
