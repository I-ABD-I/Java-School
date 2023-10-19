package whileLoops;

import utils.Input;

import java.util.Random;

public class Flags {
  public static void countPos() {
    int count = 0;

    while (Input.nextInt() > 0) count++;


    System.out.println("The amount of positive numbers is " + count);
  }

  public static void grades() {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int maxIndex;
    int minIndex;
    int index = 1;
    int num;

    System.out.println("Please enter a number");
    num = Input.nextInt();

    while (num > 0) {
      if (num > max) {
        max = num;
        maxIndex = index;
      }
      if (num < min) {
        min = num;
        minIndex = index;
      }

      if (num >= 95) System.out.println("Passed With Excellence");
      else if (num < 55) System.out.println("Failed");

      System.out.println("Please enter a number");
      num = Input.nextInt();
    }

  }

  public static void divisibleBy6Mul() {
    int total = 1;
    int num = 1;

    while (num > 0) {
      System.out.println("Please enter a number");
      num = Input.nextInt();

      if (num % 6 == 0) total *= num;
    }

    System.out.println("Your number is " + total);
  }

  public static void max2Digit() {
    int max = 0;

    System.out.println("Please enter a number");
    int num = Input.nextInt();

    while (9 < num && num < 100) {
      if (num > max && num % 10 != num / 10) max = num;

      System.out.println("Please enter a number");
      num = Input.nextInt();
    }

    System.out.println("the max is " + max);
  }

  public static void eduReform() {
    char ans = 0x0;
    int yes = 0, no = 0, none = 0;

    while (ans != 'f') {
      switch (ans) {
        case 'd' -> none++;
        case 'y' -> yes++;
        case 'n' -> no++;
      }

      System.out.println("Please enter a number");
      ans = Input.nextChar();
    }

    System.out.println("yes: " + yes + " no: " + no + " none: " + none);
    if ((double) yes * 100 / yes + no + none >= 60) System.out.println("the system will change");
    else System.out.println("the system will not change");
  }

  public static void workers() {
    double hours = 0;
    double salary = 0;

    double totalPay = 0;
    int workerCount = 0;
    System.out.println("Please enter hours and salary");
    hours = Input.nextDouble();
    salary = Input.nextDouble();
    while (hours != -999 && salary != -999) {
      totalPay += hours * salary;
      if (hours > 150) totalPay += 250;
      workerCount++;
      System.out.println("Please enter hours and salary");
      hours = Input.nextDouble();
      salary = Input.nextDouble();
    }

    System.out.println(
      "The total pay is: " + totalPay + "The avg salary is: " + totalPay / workerCount);
  }

  public static void guessChar() {
    char randomChar = (char) (new Random().nextInt(0, 26) + 'a');
    char guessed = 0;
    int tries = 5;


    while (guessed != randomChar && tries != 0) {
      guessed = Input.nextChar();
      tries--;
    }

    if (guessed == randomChar)
      if (tries != 0) System.out.println("Guessed after " + (5 - tries) + "tries");
      else System.out.println("You guessed but ran out of tries");
    else System.out.println("Ran out of tries");
  }

  public static void coinFlip() {
    int countShir = 0;
    int countLee = 0;

    while (countLee < 3 && countShir < 3) {
      System.out.println("Please enter heads or talis (0 or 1)");
      countShir += Input.nextInt();
      countLee += Input.nextInt();
    }

    if (countShir == 3) System.out.println("Shir starts");
    else if (countLee == 3) System.out.println("Lee starts");
  }

  public static void grass() {
    int totalArea = 0;
    int carpetCount = 0;
    while (totalArea < 200) {
      System.out.println("Please enter width / height");
      totalArea += Input.nextInt() * Input.nextInt();
      carpetCount++;
    }

    System.out.println("Dan bought " + carpetCount + "Carpets, it costed him " + carpetCount * 30);
  }

  public static void digitsLeftOfDot() {
    int num;
    int digitCount = 0;

    System.out.println("Please enter a number");
    num = (int) Input.nextDouble();

    while (num > 0) {
      digitCount++;
      num /= 10;
    }

    System.out.println("there are " + digitCount + " digits");
  }

  public static void numberCouple() {
    int max = Integer.MIN_VALUE;
    int now = 0;
    int coupleCount = 0;

    while (now % 2 == 0) {
      System.out.println("Please enter 2 numbers");
      now = Input.nextInt() + Input.nextInt();
      max = Math.max(now, max);
      coupleCount++;
    }

    coupleCount--;

    System.out.println("The biggest couple is " + max);
    System.out.println("The amount of couples is " + coupleCount);

  }

  public static void fibonacci() {
    int n1 = 0;
    int n2 = 1;
    int next;

    System.out.println("Please enter a number");
    int n = Input.nextInt();

    System.out.print(n1 + " ");
    while (n2 < n) {
      System.out.print(n2 + " ");
      next = n2 + n1;
      n1 = n2;
      n2 = next;
    }
  }

  public static void reverseNum() {
    System.out.println("Please enter a number");
    int num = Input.nextInt();
    while (num > 0) {
      System.out.print(num % 10);
      num /= 10;
    }

  }

  public static void fibUnder120() {
    int sum = 0;
    int n1 = 0;
    int n2 = 1;
    int next;

    System.out.print(n1 + " ");
    while (sum < 120) {
      System.out.print(n2 + " ");
      sum += n2;
      next = n1 + n2;
      n1 = n2;
      n2 = next;
    }
  }

  // ex27 - count digits
  // dosent work -> n > 0
  // works 0
  public static void countDigits() {
    int n = Input.nextInt();
    int count = 0;
    do {
      count++;
      n /= 10;
    } while (n > 0);
    System.out.println(count);

  }

  // ex28
  // loop will be 4 times
  // 10, 10
  // 5, 4


  // ex29
  // a, c, e, g
  // a
  // print all letters from a - input, with jumps of 2 (a, c, e, ..., input(if in jumps))

  public static void similarNumbers() {
    int n1, n2;
    int countSimilar = 0;

    System.out.println("Please enter 2 numbers");
    n1 = Input.nextInt();
    n2 = Input.nextInt();

    while (n1 < 100 && n2 < 100) {
      if ((n1 % 10 == n2 % 10 && n1 / 10 == n2 / 10) || (n1 % 10 == n2 / 10
                                                         && n1 / 10 == n2 % 10)) {
        System.out.println("Your numbers are similar");
        countSimilar++;
      } else System.out.println("Your numbers arent similar");

      System.out.println("Please enter 2 numbers");
      n1 = Input.nextInt();
      n2 = Input.nextInt();
    }

    System.out.println("The amount of similar numbers is " + countSimilar);
  }

  public static void longestBigger() {
    int prev;
    int num = -1;
    int count = 1;
    int maxCount = 0;

    System.out.println("Please enter a number");
    prev = Input.nextInt();

    while (num != 0) {
      System.out.println("Please enter a number");
      num = Input.nextInt();

      if (num > prev) {
        count++;
      } else {
        maxCount = Math.max(count, maxCount);
        count = 1;
      }
      prev = num;
    }
    System.out.println("The longest is " + maxCount);

  }
}
