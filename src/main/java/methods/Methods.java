package methods;

import utils.Input;

public class Methods {
  public static double dollarRatio(double prevRatio, double delta) {
    delta /= 100;
    return prevRatio + (prevRatio * delta);
  }

  public static void profitDollarChange() {
    System.out.println("Please enter the amount of dollars and the exchange rate");
    double amount = Input.nextDouble();
    double exRate = Input.nextDouble();

    double newRate = exRate;

    for (int i = 0; i < 10; i++) {
      System.out.println("Please enter the change percentage");
      newRate = dollarRatio(newRate, Input.nextDouble());
    }

    System.out.println("The amount of profit made is: " + (amount * newRate - amount * exRate));
  }

  public static int calcAvg(int grade, int level) {
    grade *= level;
    if (level == 4) return grade + 10;
    else if (level == 5) return grade + 20;
    return grade;
  }

  public static void avgGrades() {
    int totalLevel = 0;
    int totalGrade = 0;
    int subjects;
    int level;

    System.out.println("please enter the amount of subjects");
    subjects = Input.nextInt();

    for (int i = 0; i < subjects; i++) {
      System.out.println("Please enter the grade and level");
      totalGrade = calcAvg(Input.nextInt(), level = Input.nextInt());
      totalLevel += level;
    }
    System.out.println("your calculated avg is: " + totalGrade / totalLevel);
  }

  public static int timeToMin(int hours, int min) {
    return hours * 60 + min;
  }

  public static int timeDiff(int hour1, int min1, int hour2, int min2) {
    return Math.abs(timeToMin(hour1, min1) - timeToMin(hour2, min2));
  }

  public static void maxWork() {
    int max = Integer.MIN_VALUE;
    int now;
    int maxDay = 0;

    for (int i = 1; i <= 30; i++) {
      System.out.println("Please enter the start time and end time (in HH:MM)");
      now = timeDiff(Input.nextInt(), Input.nextInt(), Input.nextInt(), Input.nextInt());
      max = Math.max(now, max);
      if (max == now) maxDay = i;
    }

    System.out.println("You worked the most in day " + maxDay);
  }

  public static int changeCode(int code) {
    interface lambda {
      int mostSignificantDigit(int num);
    }
    lambda l = num -> {
      while (num > 9) num /= 10;
      return num;
    };

    code = (l.mostSignificantDigit(code) + code % 10) % 10 + code * 10;
    code = (l.mostSignificantDigit(code) + code % 10) % 10 + code * 10;

    return code;
  }

  public static void updateWorkerCodes() {
    for (int i = 0; i < 100; i++) {
      System.out.println("Please enter code");
      System.out.println("Your new code is " + changeCode(Input.nextInt()));
    }
  }

  public static int isDiffDigits(int num) {
    int[] count = new int[10];
    for (int i = 0; i < count.length; i++) count[i] = 0;

    boolean exit = false;
    while (num > 0 && !exit) {
      count[num % 10]++;
      if (count[num % 10] > 1) exit = true;
      num /= 10;
    }

    return exit ? 0 : 1;
  }

  public static void countDiffDigits() {
    int count = 0;
    int num;

    System.out.println("Please enter a number");
    num = Input.nextInt();
    while (isDiffDigits(num) == 0) {
      count++;
      System.out.println("Please enter a number");
      num = Input.nextInt();
    }

    System.out.println("The number: " + num);
    System.out.println("The amount of numbers: " + count);
  }


}
