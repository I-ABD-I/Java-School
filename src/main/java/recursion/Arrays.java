package recursion;

public class Arrays {

  public static int sumOddIndex(int[] arr) {
    return sumOddIndex(arr, 1);
  }

  public static int sumOddIndex(int[] arr, int idx) {
    if (idx == arr.length) return 0;
    return sumOddIndex(arr, idx + 2) + arr[idx];
  }

  public static boolean sorted(int[] arr) {
    return sorted(arr, 0);
  }

  public static boolean sorted(int[] arr, int idx) {
    if (idx == arr.length - 1) return true;
    if (arr[idx] < arr[idx + 1])
      return sorted(arr, idx + 1);
    return false;
  }
}
