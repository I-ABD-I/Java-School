package OOP.dominos;

public class Main {
  public static boolean isAttachable(Domino d1, Domino d2) {
    return d1.getNum1() == d2.getNum1() || d1.getNum1() == d2.getNum2()
           || d1.getNum2() == d2.getNum1() || d1.getNum2() == d2.getNum2();
  }
  
}
