package OOP.fractions;

public class Main {
  public static Fraction add(Fraction f1, Fraction f2) {
    Fraction f = new Fraction(
      f1.getNumerator() * f2.getDenominator() + f2.getNumerator() * f1.getDenominator(),
      f1.getDenominator() * f2.getDenominator());

    f.simplify();
    return f;
  }

  // This is n Fraction addition (for the 3 fraction addition function)
  public static Fraction add(Fraction f1, Fraction... f2) {
    return add(f2.length - 1, f1, f2);
  }

  public static Fraction add(int index, Fraction f1, Fraction... f2) {
    if (index == 0) return add(f1, f2[0]);
    return add(add(index - 1, f1, f2), f2[index]);
  }
}
