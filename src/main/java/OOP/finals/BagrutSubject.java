package OOP.finals;

public class BagrutSubject {
  private String subject;
  private int code;
  private double testAvg;
  private double schoolAvg;
  private int students;
  private int failed;

  public BagrutSubject(String subject,
                       int code,
                       double testAvg,
                       double schoolAvg,
                       int students,
                       int failed) {
    this.subject = subject;
    this.code = code;
    this.testAvg = testAvg;
    this.schoolAvg = schoolAvg;
    this.students = students;
    this.failed = failed;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public double getTestAvg() {
    return testAvg;
  }

  public void setTestAvg(double testAvg) {
    this.testAvg = testAvg;
  }

  public double getSchoolAvg() {
    return schoolAvg;
  }

  public void setSchoolAvg(double schoolAvg) {
    this.schoolAvg = schoolAvg;
  }

  public int getStudents() {
    return students;
  }

  public void setStudents(int students) {
    this.students = students;
  }

  public int getFailed() {
    return failed;
  }

  public void setFailed(int failed) {
    this.failed = failed;
  }
}
