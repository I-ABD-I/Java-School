package OOP.students;

import java.util.ArrayList;
import java.util.List;

public class Student {
  private final String name;
  private final List<Integer> grd = new ArrayList<Integer>();
  public Student(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public List<Integer> getGrd() {
    return grd;
  }

  public void addGrd(int grd) {
    this.grd.add(grd);
  }

  public int minGrd() {
    int min = grd.get(0);
    for (int val : grd) {
      if (val < min) min = val;
    }
    return min;
  }

  public int maxGrd() {
    int max = grd.get(0);
    for (int val : grd) {
      if (val > max) max = val;
    }
    return max;
  }

  public double avg() {
    int total = 0;
    for (int val : grd) {
      total += val;
    }
    return (double) total / grd.size();
  }

  @Override
  public String toString() {
    return "Student{" + "name='" + name + '\'' + ", grd=" + grd + '}';
  }
}
