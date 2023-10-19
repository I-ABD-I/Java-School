package OOP.numbers;

public class Numbers {
  private final int n1;
  private final int n2;
  private final int n3;

  public Numbers(int n1, int n2, int n3) {
    this.n1 = n1;
    this.n2 = n2;
    this.n3 = n3;
  }

  public int max3() {
    return Math.max(Math.max(n1, n2), n3);
  }

  public int min3() {
    return Math.min(Math.min(n1, n2), n3);
  }

  public int mid3() {
    if ((n1 < n2 && n2 < n3) || (n3 < n2 && n2 < n1)) return n2;

    else if ((n2 < n1 && n1 < n3) || (n3 < n1 && n1 < n2)) return n1;

    else return n3;
  }

  public boolean isAtLeastOneIsOneDigit() {
    if ((-1 < n1 && n1 < 10) && (-1 < n2 && n2 < 10) && (-1 < n3 && n3 < 10)) {
      System.out.println("At Least One Number Is a One Digit Number");
      return true;
    }
    return false;
  }

  public int getN1() {
    return n1;
  }

  public int getN2() {
    return n2;
  }

  public int getN3() {
    return n3;
  }
}
