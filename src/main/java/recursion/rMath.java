package recursion;

public class rMath {

    @SuppressWarnings("SpellCheckingInspection")
    public static int xTimesy(int x, int y) {
        if (x == 0)
            return 0;
        return xTimesy(x - 1, y) + y;
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static int xMody(int x, int y) {
        if (x < y)
            return x;
        return xMody(x - y, y);
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static int xOvery(int x, int y) {
        if (x < y)
            return 0;
        return xOvery(x - y, y) + 1;
    }

    public static boolean isDivisibleByEleven(int num) {
        if (num == 0) {
            return true; // 0 is divisible by 11
        }
        if (num < 11) {
            return false; // Numbers less than 11 are not divisible by 11
        }

        int lastDigit = num % 10;
        int remainingDigits = num / 10;

        // remove from orig num a number that is divisible by 11 and remove the 0 cuz it
        // dosent matter
        int newNum = remainingDigits - lastDigit;

        return isDivisibleByEleven(newNum);
    }

}
