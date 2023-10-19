package whileLoops;

import utils.Input;

public class NestedLoops {
  public static void grades() {
    String id;
    int grade;
    int countEnglish = 0;
    int countStudents = 0;
    double totalGrades = 0;
    int countSubjects = 0;

    System.out.println("Please enter your id");
    id = Input.nextLine();
    while (!id.equals("0")) {
      System.out.println("Please enter a grade");
      grade = Input.nextInt();
      if (grade >= 90) countEnglish++;
      while (grade != -999) {
        totalGrades += grade;
        countSubjects++;
        System.out.println("Please enter grade");
        grade = Input.nextInt();
      }
      System.out.println(id + "Avg grade is: " + totalGrades / countSubjects);
      countSubjects = 0;
      totalGrades = 0;
      countStudents++;
      System.out.println("Please enter id");
      id = Input.nextLine();
    }

    System.out.println("The amount of students is: " + countStudents
                       + ", the amount of students that don't need english classes is: "
                       + countEnglish);

  }

  public static void perfectNumbersV2() {
    interface lambda {
      boolean isPerfect(int n);
    }

    lambda l = n -> {
      int sum = 1;

      for (int i = 2; i < Math.sqrt(n); i++) {
        if (n % i == 0) sum += i + n / i;
      }
      return sum == n;
    };

    for (int i = 1; i <= 1000; i++) {
      if (l.isPerfect(i)) System.out.println(i + " Is perfect!");
    }
  }

  public static void smallestDigit() {
    int num;
    int smallestDigit = 10;

    System.out.println("Please enter a number");
    num = Input.nextInt();
    while (num > 9) {
      while (num > 0) {
        smallestDigit = Math.min(num % 10, smallestDigit);
        num /= 10;
      }
      System.out.println("The smallest Digit of your number is " + smallestDigit);
      System.out.println("please enter another number");
      num = Input.nextInt();
    }

  }

  public static void primesV2() {
    interface lambda {
      boolean isPrime(int n);
    }
    lambda l = n -> {
      if (n % 2 == 0) return false;
      for (int i = 3; i < Math.sqrt(n); i += 2) {
        if (n % i == 0) return false;
      }
      return true;
    };

    int primeCount = 0;
    for (int i = 0; i < 30; i++) {
      System.out.println("Please enter a number");
      if (l.isPrime(Input.nextInt())) primeCount++;
    }

    System.out.println("The amount of primes is: " + primeCount);
  }


  public static void digitalClock() throws InterruptedException {
    int hour = 0;
    int minute = 0;
    int second = 0;

    while (hour < 24) {
      System.out.print(hour + " " + minute + " " + second);
      Thread.sleep(1000);
      if (second < 60) {
        second++;
      } else {
        second = 0;
        if (minute < 60) {
          minute++;
        } else {
          minute = 0;
          hour++;
        }
      }
    }

  }

  public static void largestContinues() {
    int lastnum = 0xffffffff;
    int count = 1;
    int max = 0;
    int num;

    System.out.println("Please enter a number");
    num = Input.nextInt();

    while (num != -1) {
      if (num == lastnum + 1) count++;
      else {
        max = Math.max(count, max);
        count = 1;
      }
      lastnum = num;
      System.out.println("Please enter a number");
      num = Input.nextInt();
    }

    max = Math.max(count, max);

    System.out.println("the longest is " + max);

  }


}
