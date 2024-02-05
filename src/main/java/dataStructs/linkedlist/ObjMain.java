package dataStructs.linkedlist;

import static utils.LinkedListUtils.build;

import OOP.Rational;
import OOP.Sequance;
import utils.Node;

public class ObjMain {

    public static void main(String[] args) {
        System.out.println(sumSameDenomenator(build(
                new Rational(3, 4),
                new Rational(1, 5),
                new Rational(2, 4),
                new Rational(1, 4),
                new Rational(4, 3),
                new Rational(2, 5))));
    }

    public static Node<Sequance> seqList(Node<Integer> head) {
        int count = 1;
        Node<Integer> temp = head;
        Node<Sequance> ret = new Node<>();
        var last = ret;
        while (temp.hasNext()) {
            if (temp.getValue() != temp.getNext().getValue()) {
                last.setNext(new Node<>(new Sequance(temp.getValue(), count)));
                last = last.getNext();
                count = 1;
            } else {
                count++;
            }
            temp = temp.getNext();
        }

        last.setNext(new Node<>(new Sequance(temp.getValue(), count)));

        return ret;
    }

    public static int sumNumOfDeno(Node<Rational> head, int deno) {
        int sum = 0;
        Node<Rational> temp = head;

        while (temp != null) {
            if (temp.getValue().getDenominator() == deno) {
                sum += temp.getValue().getNumerator();
            }
            temp = temp.getNext();
        }
        return sum;
    }

    public static boolean contanisDeno(Node<Rational> head, int deno) {

        while (head != null) {
            if (head.getValue().getDenominator() == deno) {
                return true;
            }
            head = head.getNext();
        }

        return false;
    }

    public static Node<Rational> sumSameDenomenator(Node<Rational> head) {
        Node<Rational> temp = head;

        Node<Rational> ret = new Node<>(null);
        Node<Rational> last = ret;
        while (temp != null) {
            if (!contanisDeno(ret.getNext(), temp.getValue().getDenominator())) {
                last.setNext(new Node<>(new Rational(sumNumOfDeno(temp, temp.getValue().getDenominator()),
                        temp.getValue().getDenominator())));
                last = last.getNext();
            }
            temp = temp.getNext();
        }

        return ret.getNext();
    }

}
