package OOP.boxes;

public class Box {
  private String material;
  private double length;
  private double width;
  private double height;
  private String color;

  public Box() {
    length = 5;
    width = 4;
    height = 3;
    color = "gray";
    material = "Basic iron";
  }

  public Box(double length, double width, double height) {
    this.length = length;
    this.width = width;
    this.height = height;
    color = "gray";
    material = "Basic iron";

  }

  public Box(double length, double width, double height, String color) {
    this.length = length;
    this.width = width;
    this.height = height;
    this.color = color;
//    material = "Basic iron";
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

}
