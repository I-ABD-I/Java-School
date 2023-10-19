package OOP.schools;

public class School {
  private String name;
  private String city;
  private double graduatePercentage;

  public School(String name, String city, double graduatePercentage) {
    this.name = name;
    this.city = city;
    this.graduatePercentage = graduatePercentage;
  }

  @Override
  public String toString() {
    return "School{" + "name='" + name + '\'' + ", city='" + city + '\'' + ", graduatePercentage="
           + graduatePercentage + '}';
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public double getGraduatePercentage() {
    return graduatePercentage;
  }

  public void setGraduatePercentage(double graduatePercentage) {
    this.graduatePercentage = graduatePercentage;
  }

}
