package OOP.doctors;

public class Doctor {
  private String name;
  private String id;
  private String mastery;
  private double avg;
  private String area;
  private int scores;

  public Doctor(String name, String id, String mastery, String area) {
    this.name = name;
    this.id = id;
    this.mastery = mastery;
    this.area = area;
    this.avg = 0;
    this.scores = 0;
  }

  public void newRating(int score) {
    scores++;
    avg = (avg * (scores - 1) + (double) score) / scores;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMastery() {
    return mastery;
  }

  public void setMastery(String mastery) {
    this.mastery = mastery;
  }

  public double getAvg() {
    return avg;
  }

  public void setAvg(int avg) {
    this.avg = avg;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public int getScores() {
    return scores;
  }

  public void setScores(int scores) {
    this.scores = scores;
  }
}
