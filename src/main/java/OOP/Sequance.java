package OOP;

public class Sequance {
    private int value;
    private int count;

    public Sequance() {
    }

    public Sequance(int value, int count) {
        this.value = value;
        this.count = count;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Sequance [value=" + value + ", count=" + count + "]";
    }

}
