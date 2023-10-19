package utils;

public class Output {
  public static void printArr(int[] arr) {
    System.out.print('[');
    for (int i = 0; i < arr.length - 1; i++) {
      System.out.print(arr[i] + ", ");
    }
    System.out.println(arr[arr.length - 1] + "]");
  }

  public static void printArr(float[] arr) {
    System.out.print('[');
    for (int i = 0; i < arr.length - 1; i++) {
      System.out.print(arr[i] + ", ");
    }
    System.out.println(arr[arr.length - 1] + "]");
  }

  public static void printArr(double[] arr) {
    System.out.print('[');
    for (int i = 0; i < arr.length - 1; i++) {
      System.out.print(arr[i] + ", ");
    }
    System.out.println(arr[arr.length - 1] + "]");
  }

  public static void printArr(char[] arr) {
    System.out.print('[');
    for (int i = 0; i < arr.length - 1; i++) {
      System.out.print(arr[i] + ", ");
    }
    System.out.println(arr[arr.length - 1] + "]");
  }

  public static void printArr(boolean[] arr) {
    System.out.print('[');
    for (int i = 0; i < arr.length - 1; i++) {
      System.out.print(arr[i] + ", ");
    }
    System.out.println(arr[arr.length - 1] + "]");
  }

  public static <T> void printArr(T[] arr) {
    System.out.print('[');
    for (int i = 0; i < arr.length - 1; i++) {
      System.out.print(arr[i] + ", ");
    }
    System.out.println(arr[arr.length - 1] + "]");
  }
}