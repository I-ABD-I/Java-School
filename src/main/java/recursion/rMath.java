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

}
