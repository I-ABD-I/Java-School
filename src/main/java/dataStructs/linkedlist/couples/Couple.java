package dataStructs.linkedlist.couples;

public class Couple {
    private int digit;

    private int appears;

    public Couple(int digit, int appears) {
        this.digit = digit;
        this.appears = appears;
    }

    @Override
    public String toString() {
        return "Couple [digit=" + digit + ", appears=" + appears + "]";
    }

    public int getDigit() {
        return digit;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public int getAppears() {
        return appears;
    }

    public void setAppears(int appears) {
        this.appears = appears;
    }

}
