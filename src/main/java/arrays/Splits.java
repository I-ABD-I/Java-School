package arrays;

import utils.Input;
import utils.Output;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Splits {
  public static void splitEven() {
    System.out.println("Please enter the number of numbers");
    int[] original = new int[Input.nextInt()];

    for (int i = 0; i < original.length; i++) {
      System.out.println("Please enter a number");
      original[i] = Input.nextInt();
    }

    int countEven = 0, countOdd = 0;

    for (int val : original) {
      if (val % 2 == 0) countEven++;
      else countOdd++;
    }

    int[] even = new int[countEven], odd = new int[countOdd];

    countEven = 0;
    countOdd = 0;
    for (int val : original) {
      if (val % 2 == 0) even[countEven++] = val;
      else odd[countOdd++] = val;
    }

    Output.printArr(even);
    Output.printArr(odd);
  }

  public static int[] sameElements(int[] arr1, int[] arr2) {
    BiFunction<int[], Integer, Boolean> contains = (ts, t) -> {
      for (int i = 0; i < ts.length; i++) {
        if (ts[i] == t) return true;
      }
      return false;
    };

    int count = 0;
    for (int i = 0; i < arr1.length; i++) {
      if (contains.apply(arr2, arr1[i])) count++;
    }

    int[] arr = new int[count];
    count = 0;

    for (int i = 0; i < arr1.length; i++) {
      if (contains.apply(arr2, arr1[i])) arr[count++] = arr1[i];
    }

    return arr;
  }

  public static void boats(char[] last, char[] b4Last) {
    BiFunction<char[], Character, Boolean> contains = (ts, t) -> {
      for (int i = 0; i < ts.length; i++) {
        if (ts[i] == t) return true;
      }
      return false;
    };

    int count = 0;
    for (char ch = 'a'; ch <= 'z'; ch++) {
      if (!contains.apply(last, ch) || !contains.apply(b4Last, ch)) count++;
    }

    char[] now = new char[count];
    count = 0;

    for (char ch = 'a'; ch <= 'z'; ch++) {
      if (!contains.apply(last, ch) || !contains.apply(b4Last, ch)) now[count++] = ch;
    }

    Output.printArr(now);
  }

  public static void flowers(int[] flower1) {
    BiConsumer<int[], Integer> rotateLeft = (arr, i) -> {
      for (; i < arr.length - 1; i++) {
        arr[i] = arr[i + 1];
      }
      arr[arr.length - 1] = 0;
    };

    int[] flower2 = new int[flower1.length];
    int ptr = 0;
    for (int i = 0; i < flower1.length; i++) {
      if (flower1[i] / 100 == 2) {
        flower2[ptr++] = flower1[i];
        rotateLeft.accept(flower1, i--);
      }
    }

    Output.printArr(flower1);
    Output.printArr(flower2);
  }
}
