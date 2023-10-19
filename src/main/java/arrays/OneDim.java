package arrays;

import utils.Input;

public class OneDim {
  public static boolean zigZag(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (i % 2 == 0) {
        if (arr[i - 1] <= arr[i]) return false;
      } else if (arr[i - 1] >= arr[i]) return false;
    }
    return true;
  }

  public static boolean hasDollarString(char[] chars, int len) {
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '$') {
        return chars[i + (int) Math.ceil((double) len / 3) + 1] == '$' && chars[i + len - 1] == '$';
      }
    }

    return false;
  }

  public static boolean isHalfSorted(int[] arr) {
    int count = 1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] < arr[i]) count++;
      else {
        if (count >= arr.length / 2) return true;
        count = 1;
      }
    }
    return false;
  }

  public static int movies(int[] arr, int seat) {
    if (arr[seat] == 0) {
      arr[seat] = 1;
      return seat;
    }
    int countLeft = seat, countRight = seat;
    while (arr[countLeft] == 1) {
      countLeft--;
    }
    while (arr[countRight] == 1) {
      countRight++;
    }

    if (countRight - seat < seat - countLeft) {
      arr[countRight] = 1;
      return countRight;
    }
    arr[countLeft] = 1;
    return countLeft;
  }

  public static void movieV2() {
    int[] arr = new int[200];
    for (int i = 0; i < 200; i++) {
      System.out.println("Please enter wanted seat");
      System.out.println("Your seat is: " + movies(arr, Input.nextInt()));
    }
  }


}
