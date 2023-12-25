package recursion;

import java.math.BigInteger;

public class ClassExamples {

    public static int countDig(int num) {
        if (num == 0)
            return 0;
        return countDig(num / 10) + 1;
    }

    public static BigInteger fib(int n) {
        if (n == 0)
            return BigInteger.ZERO;
        if (n == 1)
            return BigInteger.ONE;
        return fib(n - 1).add(fib(n - 2));
    }

    public static int sumEvenDigits(int num) {
        if (num == 0)
            return 0;
        else if (num % 10 % 2 == 0)
            return num % 10 + sumEvenDigits(num / 10);
        else
            return sumEvenDigits(num / 10);
    }

    public static int factorial(int num) {
        if (num == 0)
            return 1;
        return factorial(num - 1) * num;
    }

    public static int sameDigit(int n, int n1) {
        if (n == 0)
            return -1;
        if (n % 10 == n1 % 10)
            return n % 10;
        return sameDigit(n / 10, n1 / 10);
    }

    public static int largestDigit(int n) {

        if (n == 0)
            return 0;

        return Math.max(n % 10, largestDigit(n / 10));
    }
}
