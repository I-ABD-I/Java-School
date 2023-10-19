package OOP.jumpers;

public class Jumper {
  private String id;
  private double record;
  private double jump1;
  private double jump2;
  private double jump3;

  public Jumper(String id) {
    this.id = id;
    record = 0;
    jump1 = 0;
    jump2 = 0;
    jump3 = 0;
  }

  @Override
  public String toString() {
    return "Jumper{" + "id='" + id + '\'' + ", record=" + record + ", jump1=" + jump1 + ", jump2="
           + jump2 + ", jump3=" + jump3 + '}';
  }

  public int updateJumps(double jump) {
    jump3 = jump2;
    jump2 = jump1;
    jump1 = jump;
    if (jump > record) {
      record = jump;
      return 1;
    }
    return 0;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public double getRecord() {
    return record;
  }

  public void setRecord(double record) {
    this.record = record;
  }

  public double getJump1() {
    return jump1;
  }

  public void setJump1(double jump1) {
    this.jump1 = jump1;
  }

  public double getJump2() {
    return jump2;
  }

  public void setJump2(double jump2) {
    this.jump2 = jump2;
  }

  public double getJump3() {
    return jump3;
  }

  public void setJump3(double jump3) {
    this.jump3 = jump3;
  }
}
