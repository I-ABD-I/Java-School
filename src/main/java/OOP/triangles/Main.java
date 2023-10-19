package OOP.triangles;

import utils.Input;

public class Main {
  public static void triangleData() {
    System.out.println("Please enter side1, side2, side3, angle1, angle2");
    Triangle triangle = new Triangle(Input.nextDouble(),
                                     Input.nextDouble(),
                                     Input.nextDouble(),
                                     Input.nextDouble(),
                                     Input.nextDouble());

    if (triangle.getSide1() + triangle.getSide2() < triangle.getSide3()
        || triangle.getSide1() + triangle.getSide3() < triangle.getSide2()
        || triangle.getSide2() + triangle.getSide3() < triangle.getSide1()) {
      System.out.println("Illegal Triangle");
    } else {
      if (triangle.getSide1() == triangle.getSide2()
          || triangle.getSide1() == triangle.getSide3()) {
        if (triangle.getSide2() == triangle.getSide3()) System.out.println("Equilateral Triangle");
        else System.out.println("isosceles Triangle");
      }
      if (triangle.getAngle1() == 90 || triangle.getAngle2() == 90 || triangle.thirdAngle() == 90)
        System.out.println("Right Angle Triangle");
    }
  }
}
