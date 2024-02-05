package dataStructs.linkedlist.birthdays;

public class Birthday {

    private int day;
    private String name;

    public Birthday(int day, String name) {
        this.day = day;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Birthday [day=" + day + ", name=" + name + "]";
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
