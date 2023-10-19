package strings;

import utils.Input;

import java.util.function.Function;

public class Strings {
  public static void printEvenLength() {
    StringBuilder print = new StringBuilder();
    String st;

    for (int i = 0; i < 40; i++) {
      System.out.println("Enter a String");
      st = Input.nextLine();

      if (st.length() % 2 == 0) print.append(st).append("\n");
    }

    System.out.println(print);
  }

  public static void hasADigit() {
    Function<String, Boolean> hasADigit = s -> {
      for (int i = 0; i < s.length(); i++) {
        if ('0' <= s.charAt(i) && s.charAt(i) <= '9') return false;
      }

      return true;
    };


    System.out.println("Please enter a String");
    System.out.println(hasADigit.apply(Input.nextLine()) ? "yes" : "no");
  }

  public static boolean firstLastEqual(String str) {
    return str.charAt(0) == str.charAt(str.length() - 1);
  }

  public static char charAt(String str, int index) {
    if (index < str.length()) return str.charAt(index);
    return 'X';
  }

  public static void password() {
    Function<String, Boolean> isValid = str -> {
      if (str.length() > 6) return false;
      int countLetters = 0;
      int countNumbers = 0;
      for (int i = 0; i < str.length(); i++) {
        if (Character.isLetter(str.charAt(i))) countLetters++;
        else if (Character.isDigit(str.charAt(i))) countNumbers++;
      }
      return countLetters >= 1 && countNumbers >= 1;
    };

    System.out.println("Please enter a password");
    while (!isValid.apply(Input.nextLine())) {
      System.out.println("password too weak");
      System.out.println("Please enter another password");
    }

  }

  public static void printConsecutiveLetters(String str) {
    for (int i = 1; i < str.length(); i++) {
      if (Character.isLetter(str.charAt(i))) if (str.charAt(i - 1) + 1 == str.charAt(i))
        System.out.println("(" + str.charAt(i - 1) + ", " + str.charAt(i) + ")");
    }
  }

  public static int getSequences(String str) {
    int sequenceCount = 1;
    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i - 1) != str.charAt(i)) sequenceCount++;
    }
    return sequenceCount;
  }
}
