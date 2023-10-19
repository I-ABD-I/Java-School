package OOP.couples;

import utils.Input;


public class Main {
  public static void isSameMinMax() {
    System.out.println("Please enter 2 numbers");
    Couple c1 = new Couple(Input.nextInt(), Input.nextInt());
    Couple c2 =
      new Couple(Math.max(c1.getNum1(), c1.getNum2()), Math.min(c1.getNum1(), c1.getNum2()));
    System.out.println((c1.equals(c2)) ? "they are the same" : "not the same");
  }

  public static void biggestSum() {
    System.out.println("Please enter 4 numbers");
    Couple c1 = new Couple(Input.nextInt(), Input.nextInt());
    Couple c2 = new Couple(Input.nextInt(), Input.nextInt());

    if (c1.equals(c2)) System.out.println(c1 + " " + c2);
    else if (c1.getNum1() + c1.getNum2() > c2.getNum1() + c2.getNum2())
      System.out.println(c1 + "\n" + c2);
    else System.out.println(c2 + "\n" + c2);
  }

  //ex16 output (Couple):
  // Insert 2 numbers
  // Insert 2 numbers
  // The new Couple:Couple{num1=25, num2=10}
  
  // ex 34 (Couples):
  // Insert 2 numbers
  // Couple{n1=3, n2= 10}

  // 11, 19
}
