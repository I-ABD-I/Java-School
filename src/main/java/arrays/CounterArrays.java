package arrays;

import utils.Input;

public class CounterArrays {

  public static void count1_10() {
    int num;
    int[] count = new int[10];

    for (int i = 0; i < count.length; i++) {
      count[i] = 0;
    }

    for (int i = 0; i < 1000; i++) {
      System.out.println("please enter a number");
      num = Input.nextInt();
      if (1 <= num && num <= 10) count[num - 1]++;
    }

    for (int i = 1; i < 11; i++) {
      System.out.println("The amount of times number " + i + " was inputted is " + count[i - 1]);
    }
  }

  public static void officeFloor() {
    int[] arr = new int[30];
    int maxOffice = 0;
    int maxFloor = 0;
    int maxF = 0;
    int maxWorkersF = 0;
    int workers;
    int maxWorkers = 0;


    for (int i = 0; i < arr.length; i++) {
      arr[i] = 0;
      for (int j = 1; j < 8; j++) {
        System.out.println("Please enter workers in floor " + i + " and office " + j);
        workers = Input.nextInt();
        if (workers > maxWorkers) {
          maxWorkers = workers;
          maxOffice = j;
          maxFloor = i;
        }

        arr[i] += workers;
      }
      if (arr[i] > maxWorkersF) {
        maxWorkersF = arr[i];
        maxF = i;
      }
    }

    System.out.println("The most workers are in floor " + maxF);
    System.out.println(
      "The office with most workers is in " + maxFloor + "and number " + maxOffice);
  }

  public static void theater() {
    int[] count = new int[15];

    for (int i = 0; i < count.length; i++) {
      count[i] = 0;
    }

    int index;
    int tickets;
    System.out.println("Please enter number of show and amount of tickets");
    index = Input.nextInt();
    tickets = Input.nextInt();

    while (index != 0) {
      count[index - 1] += tickets;
      System.out.println("Please enter number of show and amount of tickets");
      index = Input.nextInt();
      tickets = Input.nextInt();
    }

    for (int i = 0; i < count.length; i++) {
      System.out.println("show " + (i + 1) + " needs " + count[i]);
    }
  }

  public static void workers() {
    System.out.println("Please enter the number of workers");
    int num = Input.nextInt();
    int[] count = new int[num];

    System.out.println("Please enter worker id");
    int workerID = Input.nextInt();
    while (workerID != -999) {
      for (int i = 0; i < count.length; i++) {
        System.out.println("Enter 1 if u support " + (i + 1) + " Enter 0 if not");
        count[i] += Input.nextInt();
      }

      System.out.println("Please enter worker id");
      workerID = Input.nextInt();
    }

    int maxIndex = 0;
    int totalVotes = 0;
    for (int i = 0; i < count.length; i++) {
      if (count[i] > count[maxIndex]) maxIndex = i;
      totalVotes += count[i];
    }

    System.out.println(maxIndex + " Got the most votes");
    totalVotes /= num;
    for (int i = 0; i < count.length; i++) {
      if (count[i] < totalVotes) System.out.println((i + 1) + "Got less votes then the avg");
    }
  }

  public static void grades() {
    int[] count = new int[101];

    for (int i = 0; i < count.length; i++) {
      count[i] = 0;
    }

    for (int i = 0; i < 200; i++) {
      System.out.println("Please enter grade");
      count[Input.nextInt()]++;
    }

    for (int i = 100; i >= 0; i--) {
      System.out.println(count[i] + "Students got " + i);
    }

    int max = 0;
    int total = 0;
    int maxRange = 0;

    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        total += count[i + j];
      }
      if (total > max) {
        max = total;
        maxRange = i;
      }
      total = 0;
    }


    System.out.println("The Max Range is: " + maxRange * 10 + '-' + maxRange * 10 + 9);
  }

  public static void nobelPrize() {
    int[] winners = new int[50];
    String choice;

    for (int i = 0; i < winners.length; i++) {
      winners[i] = 0;
    }

    for (int i = 0; i < 10; i++) {
      System.out.println("Please enter your choice");
      choice = Input.nextLine();

      String[] temp = choice.split(",");
      for (int j = 0; j < temp.length; j++) {
        winners[Integer.parseInt(temp[j])] += 3 - j;
      }
    }

    int first = 0, vFirst = 0, second = 0, vSecond = 0, third = 0, vThird = 0;
    for (int i = 0; i < winners.length; i++) {
      if (winners[i] > vFirst) {
        vFirst = winners[i];
        first = i;
      } else if (winners[i] > vSecond) {
        vSecond = winners[i];
        second = i;
      } else if (winners[i] > vThird) {
        vThird = winners[i];
        third = i;
      }
    }

    System.out.println(
      "First Place: " + first + " Second Place: " + second + " Third Place: " + third);
  }

  static void randomArray(int[] a) {
    for (int i = 0; i <= 9; i++) {
      int num = (int) (Math.random() * 10) + 1;
      a[num]++;
    }
  }

}
