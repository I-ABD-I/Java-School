package dataStructs.linkedlist;

import static utils.LinkedListUtils.build;

import utils.Node;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(isSorted(build(1, 2, 3, 4, 5)));
        System.out.println(countEven(build(1, 2, 3, 4, 4)));
        printEvenIndex(build(1, 2, 3, 4, 5, 6, 7));
        var list = build(1, 2, 3, 4, 5, 6, 7);
        var p = list;
        for (int i = 0; i < 4; i++) {
            p = p.getNext();
        }
        System.out.println(p.getValue());
        System.out.println(sumFromTo(list, p));

        list = build(1, 4, 3, 9, -2, 4, -25, 5, 2, 8, 1, 1);
        System.out.println(arithmeticSeq(list));
        System.out.println(list);
    }

    public static boolean isSorted(Node<Integer> head) {
        if (head == null || head.getNext() == null) {
            return true;
        }
        return head.getValue() <= head.getNext().getValue() && isSorted(head.getNext());
    }

    public static int countEven(Node<Integer> head) {
        if (head == null) {
            return 0;
        }
        return (head.getValue() % 2 == 0 ? 1 : 0) + countEven(head.getNext());
    }

    public static void printEvenIndex(Node<Integer> head) {
        if (head == null) {
            return;
        }
        System.out.println(head.getValue());
        if (head.getNext() == null) {
            return;
        }
        printEvenIndex(head.getNext().getNext());
    }

    public static int sumFromTo(Node<Integer> from, Node<Integer> to) {
        if (from == to)
            return from.getValue();

        return from.getValue() + sumFromTo(from.getNext(), to);
    }

    public static int diffSize(Node<Integer> lst1, Node<Integer> lst2) {
        if (lst1 == null && lst2 == null) {
            return 0;
        }
        if (lst1 == null) {
            return 1 + diffSize(lst1, lst2.getNext());
        }
        if (lst2 == null) {
            return 1 + diffSize(lst1.getNext(), lst2);
        }
        return diffSize(lst1.getNext(), lst2.getNext());
    }

    public static Node<Integer> arithmeticSeq(Node<Integer> head) {
        Node<Integer> newL = new Node<>(null);
        Node<Integer> temp = newL;
        while (head != null) {
            int a1 = head.getValue();
            int d = head.getNext().getValue();
            int n = head.getNext().getNext().getValue();

            for (int i = 0; i < n; i++) {
                temp.setNext(new Node<>(a1 + i * d));
                temp = temp.getNext();
            }
            head = head.getNext();
            head.setNext(head.getNext().getNext());
            head = head.getNext();
        }

        return newL.getNext();
    }
}
