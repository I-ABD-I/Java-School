package forLoop;

import utils.Input;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Multiply {
  public static void Factorial() {
    Function<Integer, Integer> factorial = (n) -> {
      int temp = 1;
      for (int i = 1; i <= n; i++) temp *= i;
      return temp;
    };

    System.out.println("Please enter a number");
    System.out.println("your number factorial is " + factorial.apply(Input.nextInt()));
  }

  public static void powerOf() {
    int ans = 1;
    int n, m;

    System.out.println("Enter 2 Numbers");
    n = Input.nextInt();
    m = Input.nextInt();

    for (int i = 1; i <= m; i++) {
      ans *= n;
    }

    System.out.println("first num ^ second num = " + ans);
  }

  public static void perfectNum() {
    int n;
    int totalDivisors = 1;
    List<Integer> divList = new ArrayList<>();
    divList.add(1);

    System.out.println("Enter a number");
    n = Input.nextInt();

    for (int i = 2; i < Math.sqrt(n); i++) {
      if (n % i == 0) {
        totalDivisors += i + n / i;
        divList.add(i);
        divList.add(n / i);
      }
    }

    if (totalDivisors == n) {
      System.out.println("Perfect Num");
      divList.sort(Comparator.naturalOrder());
      for (var i : divList.subList(0, divList.size() - 1)) {
        System.out.print(i + " + ");
      }
      System.out.println(divList.get(divList.size() - 1) + " = " + n);
    }
  }
}
