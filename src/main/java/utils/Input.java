package utils;

import java.util.Scanner;

public class Input {
  public static Scanner reader = new Scanner(System.in);

  public static int nextInt() {
    while (true) {
      try {
        return Integer.parseInt(reader.nextLine());
      } catch (Exception exception) {
        System.out.println("Invalid Input");
      }
    }
  }

  public static String next() {
    return reader.next();
  }

  public static String nextLine() {
    return reader.nextLine();
  }

  public static double nextDouble() {
    while (true) {
      try {
        return Double.parseDouble(reader.nextLine());
      } catch (Exception ex) {
        System.out.println("Invalid Input");
      }
    }
  }

  public static char nextChar() {
    return reader.next().charAt(0);
  }

}
