package forLoop;

import utils.Input;

import java.util.function.Function;

public class Counters {
  public static void someTemperature() {
    int counter = 0;
    for (int i = 1; i <= 7; i++) {
      System.out.println("Please enter a temperature");
      if (Input.nextInt() > 16) counter++;
    }

    System.out.println("The Amount Of Days With Temperature Above 16° is " + counter);
  }

  public static void countEven() {
    int evenCount = 0;
    int negCount = 0;
    int num;

    for (int i = 0; i < 81; i++) {
      System.out.println("Please enter a number");
      num = Input.nextInt();

      if (num % 2 == 0) evenCount++;
      if (num < 0) negCount++;
    }

    System.out.println(
      "The Amount of Even Numbers Is " + evenCount + "The Amount of Negative Numbers Is "
      + negCount);
  }

  public static void countIntSqrt() {
    int counter = 0;
    for (double i = 1; i <= 300; i++) {
      if (Math.sqrt(i) % 1 == 0) counter++;
    }

    System.out.println("The Amount Of Square Numbers Between 1 and 300 is " + counter);
  }

  public static void count2Works() {
    int counter = 0;

    for (int i = 0; i < 20; i++) {
      System.out.println("Please enter 2 Numbers");
      if (Input.nextInt() != -1 && Input.nextInt() != -1) counter++;
    }

    System.out.println("The Amount Of Students that did Both Works is " + counter);
  }

  public static void theoryTest() {
    int counter = 0;
    int n;
    System.out.println("Please enter the amount of ppl");
    n = Input.nextInt();

    for (int i = 0; i < n; i++) {
      System.out.println("Please Enter the amount of Mistakes in: traffic Signs, other questions");
      if (Input.nextInt() == 1 && Input.nextInt() >= 3) counter++;
    }

    System.out.println(
      "The Amount Of ppl that passed is " + counter + "The Percentage of ppl that passed is "
      + (double) (counter / n) * 100);
  }

  public static void primeNumbers() {

    int number;

    Function<Integer, Boolean> isPrime = n -> {
      if (n % 2 != 0) {
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
          if (n % i == 0) {
            return false;
          }
        }
        return true;
      }
      return false;
    };


    System.out.println("Please enter a number");
    number = Input.nextInt();


    System.out.println(
      (isPrime.apply(number)) ? "Your Number is Prime" : "Your Number isn't Prime");
  }

  public static void basketBall() {
    int roy, tal;

    for (int i = 0; i < 10; i++) {
      System.out.println("Enter the amount of points tal scored");
      tal = Input.nextInt();

      System.out.println("Enter the amount of points roy scored");
      roy = Input.nextInt();

      if (tal > roy) System.out.println("tal scored more");
      else System.out.println("roy scored more");

      System.out.println("They Scored a total of " + (roy + tal) + "Points");
    }
  }

  public static void avgBigger() {
    int n, n2;
    int total = 0;
    for (int i = 0; i < 20; i++) {
      System.out.println("Enter 2 numbers");
      n = Input.nextInt();
      n2 = Input.nextInt();

      total += Math.max(n, n2);
    }

    System.out.println("the avg of the bigger numbers is " + ((double) total / 20));
  }

  public static void carRace() {
    String id;
    double time_min;
    int countUnder4 = 0;
    double totalTime = 0;

    for (int i = 0; i < 40; i++) {
      System.out.println("Please enter the car ID, and the time in min");
      id = Input.nextLine();
      time_min = Input.nextDouble();

      if (time_min > 5) System.out.println("Doesn't pass");
      else if (time_min < 4) {
        System.out.println(id);
        countUnder4++;
      }
      totalTime += time_min;
    }

    System.out.println(
      "The Amount of cars under 4 min is " + countUnder4 + "The avg time is " + totalTime / 40);
  }
}
