package OOP.city;

public class CameraInfo {
  int city;
  int maxSpeed;
  CarInfo[] cars;

  public CarInfo[] getCars() {
    return cars;
  }

  public void setCars(CarInfo[] cars) {
    this.cars = cars;
  }

  public int getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(int maxSpeed) {
    this.maxSpeed = maxSpeed;
  }

  public int getCity() {
    return city;
  }

  public void setCity(int city) {
    this.city = city;
  }

  public boolean allGood() {
    for (var car : cars) {
      if (!car.illegal(maxSpeed)) return false;
    }
    return true;
  }

}
