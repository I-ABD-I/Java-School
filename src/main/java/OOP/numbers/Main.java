package OOP.numbers;

import OOP.couples.Couple;
import utils.Input;

public class Main {


  public static void threeNum() {
    Numbers num;
    Couple couple;

    System.out.println("Please enter 3 numbers");
    num = new Numbers(Input.nextInt(), Input.nextInt(), Input.nextInt());

    if (num.max3() - num.mid3() < num.mid3() - num.min3())
      couple = new Couple(num.max3(), num.mid3());
    else couple = new Couple(num.mid3(), num.min3());

    System.out.println(couple);
  }
  
  // ex 36:
  // res = 6.0
  // (15,12,10), (10, 8, 5)
}
