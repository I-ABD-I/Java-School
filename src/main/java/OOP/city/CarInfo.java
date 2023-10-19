package OOP.city;

public class CarInfo {
  String id;
  boolean privateCar;
  int speed;

  public boolean illegal(int maxSpeed) {
    return maxSpeed < speed;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public boolean isPrivateCar() {
    return privateCar;
  }

  public void setPrivateCar(boolean privateCar) {
    this.privateCar = privateCar;
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

}
