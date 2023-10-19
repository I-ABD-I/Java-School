package OOP.fractions;

public class Fraction {
  private int numerator;
  private int denominator;

  public Fraction(int numerator, int denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public int maxDivisor() {
    for (int i = Math.min(denominator, numerator); i > 0; i--) {
      if (denominator % i == 0 && numerator % i == 0) return i;
    }
    return 1;
  }

  public void simplify() {
    int delta = maxDivisor();
    denominator /= delta;
    numerator /= delta;
  }

  @Override
  public String toString() {
    return "Fraction{" + "numerator=" + numerator + ", denominator=" + denominator + '}';
  }

  public int getNumerator() {
    return numerator;
  }

  public void setNumerator(int numerator) {
    this.numerator = numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  public void setDenominator(int denominator) {
    this.denominator = denominator;
  }
}
