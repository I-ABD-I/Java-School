package dataStructs.linkedlist.birthdays;

import static utils.LinkedListUtils.length;

import utils.Node;

public class AllBirthday {

    private Node<Birthday>[] birthdays;

    @SuppressWarnings("unchecked")
    public AllBirthday() {
        this.birthdays = new Node[13];
    }

    public Node<Birthday>[] getBirthdays() {
        return birthdays;
    }

    public void setBirthdays(Node<Birthday>[] birthdays) {
        this.birthdays = birthdays;
    }

    public void addBirthday(Birthday birthday, int month) {
        birthdays[month] = new Node<Birthday>(birthday, birthdays[month]);
    }

    public void removeBirthday(int month, int day, String name) {
        Node<Birthday> current = birthdays[month];
        if (current == null) {
            return;
        }
        if (current.getValue().getDay() == day && current.getValue().getName().equals(name)) {
            birthdays[month] = current.getNext();
            return;
        }

        while (current.hasNext()) {
            if (current.getNext().getValue().getDay() == day && current.getNext().getValue().getName().equals(name)) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }
    }

    public int biggestBirthday() {
        int maxMonth = 1;
        int max = 0;

        for (int i = 1; i < birthdays.length; i++) {
            int count = length(birthdays[i]);
            if (count > max) {
                max = count;
                maxMonth = i;
            }
        }
        return maxMonth;
    }
}
