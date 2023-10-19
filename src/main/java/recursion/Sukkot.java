package recursion;

public class Sukkot {

  /*
  ----------------------------------------
                  PAGE 1
  ----------------------------------------
   */
  // ex1
  public static int len(int num) {
    if (num < 10) return 1;
    return 1 + len(num / 10);
  }

  // ex2
  public static int countDigAbv5(int num) {
    if (num == 0) return 0;
    return (num % 10 > 5 ? 1 : 0) + countDigAbv5(num / 10);
  }

  //  ex3
  public static int countEvenDig(int num) {
    if (num == 0) return 0;
    return (num % 10 % 2 == 0 ? 1 : 0) + countEvenDig(num / 10);
  }

  // ex4
  public static int digitInPos(int num, int pos) {
    if (num == 0) return -1;
    if (pos == 0) return num % 10;
    return digitInPos(num / 10, pos - 1);
  }

  // ex5
  public static int sameDigitInPos(int n1, int n2) {
    if (n1 == 0 || n2 == 0) return -1;
    if (n1 % 10 == n2 % 10) return n1 % 10;
    return sameDigitInPos(n1 / 10, n2 / 10);
  }

  // ex6
  public static int maxDigit(int num) {
    if (num < 10) return num;
    return Math.max(num % 10, maxDigit(num / 10));
  }

  // ex7
  public static int countOddPosDigits(int num) {
    if (num < 10) return 0;
    num /= 10;
    return countOddPosDigits(num / 10) + num % 10;
  }
  /*
  ----------------------------------------
                PAGE 2
                Numbers
  ----------------------------------------
   */

  // ex1
  public static int mul(int n1, int n2) {
    if (n2 == 0) return 0;
    return n1 + mul(n1, n2 - 1);
  }

  // ex2
  public static int pow(int n1, int n2) {
    if (n2 == 0) return 1;
    return n1 * pow(n1, n2 - 1);
  }

  // ex3
  public static int div(int n1, int n2) {
    if (n1 < n2) return 0;
    return 1 + div(n1 - n2, n2);

  }

  // ex4
  public static int divRem(int n1, int n2) {
    if (n1 < n2) return n1;
    return divRem(n1 - n2, n2);
  }

  /*
  ----------------------------------------
                PAGE 2
                Arrays
  ----------------------------------------
 */

  // ex1
  public static int sumUntilPos(int[] arr, int pos) {
    if (pos == -1) return 0;
    return arr[pos] + sumUntilPos(arr, pos - 1);
  }

  // ex2
  public static int sumNeg(int[] arr, int pos) {
    if (pos == arr.length) return 0;
    return Math.min(arr[pos], 0) + sumNeg(arr, pos + 1);
  }

  // ex3

  public static boolean isPalindrome(int[] arr) {
    return isPalindrome(arr, 0);
  }

  public static boolean isPalindrome(int[] arr, int pos) {
    if (pos == arr.length / 2) return true;
    return arr[pos] == arr[arr.length - pos - 1] && isPalindrome(arr, pos + 1);
  }

  // ex4
  public static boolean isAP(int[] arr) {
    return isAP(arr, 0);
  }

  public static boolean isAP(int[] arr, int pos) {
    if (pos == arr.length - 2) return true;
    return arr[pos + 1] - arr[pos] == arr[pos + 2] - arr[pos + 1] && isAP(arr, pos + 1);
  }

  // ex5
  public static boolean isSymmetrical(int[] arr) {
    return isSymmetrical(arr, 0);
  }

  public static boolean isSymmetrical(int[] arr, int pos) {
    if (pos == arr.length / 2) return true;
    return arr[pos] + arr[arr.length - pos - 1] == arr[pos + 1] + arr[arr.length - pos - 2]
           && isSymmetrical(arr, pos + 1);
  }

  // ex6
  public static boolean isPalindrome(String str, int pos) {
    if (pos == str.length() / 2) return true;
    return str.charAt(pos) == str.charAt(str.length() - pos - 1) && isPalindrome(str, pos + 1);
  }

  public static boolean isPalindrome(String str) {
    return isPalindrome(str, 0);
  }

  /*
  ----------------------------------------
                PAGE 2
                 void
  ----------------------------------------
 */

  // ex1
  public static void printNumRTL(int num) {
    if (num < 10) System.out.println(num);
    else {
      System.out.println(num % 10);
      printNumRTL(num / 10);
    }
  }

  // ex2
  public static void printNumLTR(int num) {
    if (num < 10) System.out.println(num);
    else {
      printNumLTR(num / 10);
      System.out.println(num % 10);
    }
  }


  // ex3
  public static void printStarRow(int num) {
    if (num == 1) System.out.println("*");
    else {
      System.out.print("*");
      printStarRow(num - 1);
    }
  }

  // ex4
  public static void printTriangle(int num) {
    if (num == 1) System.out.println("*");
    else {
      printTriangle(num - 1);
      System.out.println("*".repeat(num));
    }
  }

  // ex5
  public static void printTriangleUpsideDown(int num) {
    if (num == 1) System.out.println("*");
    else {
      System.out.println("*".repeat(num));
      printTriangleUpsideDown(num - 1);
    }
  }
}
