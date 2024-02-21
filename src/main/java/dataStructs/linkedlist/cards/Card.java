package dataStructs.linkedlist.cards;

public class Card {
    private int digit;
    private char color;

    public Card(int digit, char color) {
        this.digit = digit;
        this.color = color;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public int getDigit() {
        return digit;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    @Override
    public String toString() {
        return "[" + digit + ", " + color + "]";
    }

}
