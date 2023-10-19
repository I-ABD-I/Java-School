package OOP.triangles;

public class Triangle {
  private double side1;
  private double side2;
  private double side3;
  private double angle1;
  private double angle2;

  public Triangle(double side1, double side2, double side3, double angle1, double angle2) {
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
    this.angle1 = angle1;
    this.angle2 = angle2;
  }

  public double thirdAngle() {
    return 180 - angle1 - angle2;
  }

  public double getSide1() {
    return side1;
  }

  public void setSide1(double side1) {
    this.side1 = side1;
  }

  public double getSide2() {
    return side2;
  }

  public void setSide2(double side2) {
    this.side2 = side2;
  }

  public double getSide3() {
    return side3;
  }

  public void setSide3(double side3) {
    this.side3 = side3;
  }

  public double getAngle1() {
    return angle1;
  }

  public void setAngle1(double angle1) {
    this.angle1 = angle1;
  }

  public double getAngle2() {
    return angle2;
  }

  public void setAngle2(double angle2) {
    this.angle2 = angle2;
  }
}
