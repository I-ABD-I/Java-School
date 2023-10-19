package OOP.advertisements;

public class Advertisement {
  public static final int price = 800;
  private String name;
  private String company;
  private int length;

  public Advertisement(String name, String company, int length) {
    this.name = name;
    this.company = company;
    this.length = length;
  }

  public String getTime() {
    if (length >= 60 * 60) return length / 3600 + ":" + length % 3600 / 60 + ":" + length % 60;
    else if (length >= 60) return (length / 60 + ":" + length % 60);
    return String.valueOf(length);
  }

  @Override
  public String toString() {
    return "Advertisement{" + "name='" + name + '\'' + ", company='" + company + '\'' + ", length="
           + length + '}';
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }
}
