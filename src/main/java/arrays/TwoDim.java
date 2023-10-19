package arrays;

public class TwoDim {
  public static void printRows(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      int sum = 0;
      for (int j = 0; j < arr[i].length; j++) {
        sum += arr[i][j];
      }
      System.out.println("The sum of row " + i + " is " + sum);
      sum = 0;
    }
  }

  public static void printCol(int[][] arr) {
    for (int i = 0; i < arr[0].length; i++) {
      int sum = 0;
      for (int j = 0; j < arr.length; j++) {
        sum += arr[j][i];
      }
      System.out.println("The sum of col " + i + "is " + sum);
      sum = 0;
    }
  }

  public static int sumPerimeter(int[][] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      if (i == 0 || i == arr.length - 1) for (int j = 0; j < arr[i].length; j++) sum += arr[i][j];
      else sum += arr[i][0] + arr[i][arr[i].length - 1];
    }
    return sum;
  }

  public static int sumDiagonal1(int[][] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i][i];
    }
    return sum;
  }

  public static int sumDiagonal2(int[][] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i][arr.length - i - 1];
    }
    return sum;
  }

  public static int sumAbvDiagonal1(int[][] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr[i].length; j++) {
        sum += arr[i][j];
      }
    }
    return sum;
  }

  public static int sumBelDiagonal1(int[][] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < i; j++) {
        sum += arr[i][j];
      }
    }
    return sum;
  }

  public static int sumAbvDiagonal2(int[][] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length - i - 1; j++) {
        sum += arr[i][j];
      }
    }
    return sum;
  }

  public static int sumBelDiagonal2(int[][] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = arr[i].length - i; j < arr[i].length; j++) {
        sum += arr[i][j];
      }
    }
    return sum;
  }

  public static boolean isFoldable(int[][] arr) {
    for (int i = 0; i < arr.length / 2; i++) {
      for (int j = 0; j < arr[i].length / 2; j++) {
        if (arr[i][j] != arr[i][arr[i].length - 1 - j] || arr[i][j] != arr[arr.length - 1 - i][j]
            || arr[i][j] != arr[arr.length - 1 - i][arr[i].length - 1 - j]) {
          return false;
        }
      }
    }
    return true;
  }

  public static boolean isSorted(int[][] arr) {
    int prev = arr[0][0];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] < prev) return false;
        prev = arr[i][j];
      }
    }
    return true;
  }

  public static int sumRow(int[][] arr, int row) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i][row];
    }
    return sum;
  }

  public static int sumCol(int[][] arr, int col) {
    int sum = 0;
    for (int i = 0; i < arr[col].length; i++) {
      sum += arr[col][i];
    }
    return sum;
  }

  public static boolean isMagicSquare(int[][] arr) {
    int temp = sumRow(arr, 0);

    for (int i = 0; i < arr.length; i++) {
      if (sumRow(arr, i) != temp || sumCol(arr, i) != temp) return false;
    }

    return temp == sumDiagonal1(arr) && temp == sumDiagonal2(arr);
  }
}
