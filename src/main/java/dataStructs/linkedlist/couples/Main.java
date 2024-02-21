package dataStructs.linkedlist.couples;

import static utils.LinkedListUtils.build;

import utils.Node;

public class Main {
    public static Node<Couple> maxDigit(Node<Couple> head) {
        Node<Couple> max = head;
        Node<Couple> current = head;
        while (current != null) {
            if (current.getValue().getDigit() > max.getValue().getDigit()) {
                max = current;
            }
            current = current.getNext();
        }
        return max;
    }

    public static Node<Couple> remove(Node<Couple> head, Node<Couple> toRemove) {
        Node<Couple> current = head;

        if (current == toRemove) {
            head = head.getNext();
            // can do there insted while to the end and change the first couple to the last
            // one to get the same result they wanted
            /*
             * Node<Couple> prev = current;
             * while (current.hasNext()) {
             * prev = current;
             * current = current.getNext();
             * }
             *
             * prev.setNext(null);
             * head.setValue(current.getValue());
             */
        } else {
            while (current.getNext() != toRemove) {
                current = current.getNext();
            }
            current.setNext(toRemove.getNext());
        }
        return head;

    }

    public static int getLargestNumber(Node<Couple> head, int digits) {
        int num = 0;
        while (digits-- > 0) {
            var max = maxDigit(head);
            num = num * 10 + max.getValue().getDigit();
            max.getValue().setAppears(max.getValue().getAppears() - 1);

            if (max.getValue().getAppears() == 0) {
                head = remove(head, max);
            }
        }

        return num;
    }

    public static void main(String[] args) {
        Node<Couple> lst = build(
                new Couple(7, 2),
                new Couple(1, 23),
                new Couple(9, 3),
                new Couple(5, 12),
                new Couple(4, 10));

        // lst -> (7,2) -> (1,23) -> (9,3) -> (5,12) -> (4,10) -> null

        System.out.println(getLargestNumber(lst, 6));

        // lst -> (7,0) -> (1,23) -> (5,11) -> (4,10) -> null
        // they want:
        // lst -> (4, 10) -> (1, 23) -> (5, 11) -> null

        System.out.println(lst);
    }
}
