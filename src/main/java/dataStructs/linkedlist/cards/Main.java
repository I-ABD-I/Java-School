package dataStructs.linkedlist.cards;

import static utils.LinkedListUtils.build;

import utils.Node;

public class Main {
    public static Node<Card> insertCard(Node<Card> head, Card card) { // O(n)
        Card max = MaxForColor(head, card.getColor()); // O(n)

        if (max == null || max == head.getValue()) {
            head = new Node<Card>(card, head);
            return head;
        }

        Node<Card> current = head;
        while (current.hasNext()) { // O(n)
            if (current.getNext().getValue() == max) {
                current.setNext(new Node<Card>(card, current.getNext()));
                return head;
            }
            current = current.getNext();
        }

        return head;
    }

    public static Card MaxForColor(Node<Card> head, char color) { // O(n)
        Card maxCard = null;
        while (head != null) { // O(n)
            if (head.getValue().getColor() == color
                    && (maxCard == null || head.getValue().getDigit() > maxCard.getDigit())) {
                maxCard = head.getValue();
            }
            head = head.getNext();
        }
        return maxCard;
    }

    // O(n)
    public static void fix(Node<Integer> head) {
        Node<Integer> current = head;

        int count = 0;
        Node<Integer> startSeq;

        while (current.hasNext()) { // only on each element
            startSeq = current;
            count = current.getNext().getValue();

            while (current.hasNext() // O(n)
                    && startSeq.getNext().getValue() == current.getNext().getValue()) {
                count--;
                current = current.getNext();
            }

            if (count < 0) {
                for (int i = 0; i > count; i--) {
                    startSeq.setNext(startSeq.getNext().getNext());
                }
            } else if (count > 0) {
                for (int i = 0; i < count; i++) {
                    startSeq.setNext(new Node<Integer>(startSeq.getNext().getValue(), startSeq.getNext()));
                }
            }
        }
    }

    public static void main(String[] args) {

        var lst = build(
                new Card(3, 'Y'),
                new Card(5, 'R'),
                new Card(1, 'B'),
                new Card(4, 'G'),
                new Card(8, 'R'),
                new Card(7, 'Y'));

        System.out.println(insertCard(lst, new Card(6, 'R')));

        fix(build(1, 2, 2, 3, 3, 4, 4, 4, 4, 4, 4, 5));
    }

}
