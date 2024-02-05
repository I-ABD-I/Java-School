package dataStructs.linkedlist;

import static utils.LinkedListUtils.build;
import static utils.LinkedListUtils.contains;
import static utils.LinkedListUtils.length;
import static utils.LinkedListUtils.removeAll;
import static utils.LinkedListUtils.reverse;

import OOP.Rational;
import utils.Node;

public class Main {
    public static void listMain() {
        System.out.println(ObjMain.sumSameDenomenator(build(
                new Rational(3, 4),
                new Rational(1, 5),
                new Rational(2, 4),
                new Rational(1, 4),
                new Rational(4, 3),
                new Rational(2, 5))));
    }

    public static Node<Integer> removeDupes(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp != null) {
            temp.setNext(removeAll(temp.getNext(), temp.getValue()));
            temp = temp.getNext();
        }
        return head;
    }

    public static Node<Integer> listAnd(Node<Integer> list, Node<Integer> list2) {
        Node<Integer> ret = new Node<>(0);
        Node<Integer> last = ret;
        while (list != null) {
            if (contains(list2, list.getValue()) && !contains(ret, list.getValue())) {
                last.setNext(new Node<>(list.getValue()));
                last = last.getNext();
            }
            list = list.getNext();
        }

        return ret.getNext();
    }

    public static Node<Integer> delFromList(Node<Integer> list, int toRemove) {
        if (list.getValue() == toRemove) {
            return list.getNext();
        }

        Node<Integer> p = list.getNext();
        Node<Integer> prev = list;
        int counter = 0;
        while (p != null) {
            if (p.getValue() == toRemove && counter == 0) {
                prev.setNext(p.getNext());
                counter++;
                p.setNext(null);
            }
            p = p.getNext();
            prev = prev.getNext();
        }

        return list;
    }

    public static Node<Integer> insertInSorted(Node<Integer> head, int value) {
        if (head == null) {
            return new Node<>(value);
        }
        if (head.getValue() > value) {
            return new Node<>(value, head);
        }

        Node<Integer> temp = head;
        while (temp.getNext() != null && temp.getNext().getValue() < value) {
            temp = temp.getNext();
        }
        temp.setNext(new Node<>(value, temp.getNext()));
        return head;
    }

    public static Node<Integer> moveEvenToStart(Node<Integer> head) {
        var current = head;
        while (current.hasNext()) {
            var next = current.getNext();
            if (next.getValue() % 2 == 0) {
                current.setNext(next.getNext());
                next.setNext(head);
                head = next;
            } else {
                current = next;
            }
        }

        return head;
    }

    public static Node<Integer> removeSeqMoreThen2(Node<Integer> head) {
        Node<Integer> current = head;
        int count = 1;
        Node<Integer> startSeq = head;
        var next = current.getNext();
        while (current.hasNext()) {
            next = current.getNext();
            if (current.getValue() == next.getValue()) {
                count++;
            } else {
                if (count > 2) {
                    if (startSeq == head)
                        head = next;
                    startSeq.setNext(next);
                }
                count = 1;
                startSeq = current;
            }
            current = next;

        }
        if (count > 2) {
            if (startSeq == head)
                head = next.getNext();
            startSeq.setNext(next.getNext());
        }

        return head;
    }

    public static <T> Node<T> combineOneAfterAnother(Node<T> list1, Node<T> list2) {
        Node<T> ret = new Node<>(null);
        Node<T> last = ret;
        while (list1 != null && list2 != null) {
            last.setNext(new Node<>(list1.getValue()));
            list1 = list1.getNext();
            last = last.getNext();
            last.setNext(new Node<>(list2.getValue()));
            last = last.getNext();
            list2 = list2.getNext();
        }
        if (list1 != null) {
            last.setNext(list1);
        }
        if (list2 != null) {
            last.setNext(list2);
        }
        return ret.getNext();
    }

    public static Node<Integer> multList(Node<Integer> list1, Node<Integer> list2) {
        Node<Integer> ret = new Node<>(0);
        int sum = 0;
        while (list2 != null) {
            sum += list2.getValue();
            list2 = list2.getNext();
        }

        var last = ret;
        while (list1 != null) {
            last.setNext(new Node<>(list1.getValue() * sum));
            list1 = list1.getNext();
            last = last.getNext();
        }
        return ret.getNext();

    }

    public static Node<Integer> allNumsTillMaxWithoutExisiting(Node<Integer> list, int max) {
        Node<Integer> ret = new Node<>(0);
        Node<Integer> last = ret;
        for (int i = 1; i < max; i++) {
            if (!contains(list, i)) {
                last.setNext(new Node<>(i));
                last = last.getNext();
            }
        }
        return ret.getNext();
    }

    public static int countProd(Node<Integer> list, int num) {
        int count = 0;
        while (list != null) {
            if (list.getValue() != 0 && !contains(list, num / list.getValue())) {
                count++;
            }
            list = list.getNext();
        }
        return count;
    }

    public static Node<Integer> ex13(Node<Integer> head) {
        int length = length(head);

        if (length % 2 == 0) {
            Node<Integer> current = head;
            for (int i = 2; i < length / 2; i++) {
                current = current.getNext();
            }

            // current.next is the first middle
            // current.next.next is the second middle

            if (current.getNext().getValue() > current.getNext().getNext().getValue()) {
                current.setNext(current.getNext().getNext());
            } else {
                current.getNext().setNext(current.getNext().getNext().getNext());
            }

            return head;
        } else {
            Node<Integer> current = head;
            while (--length > 1) {
                current = current.getNext();
            }
            current.setNext(null);
            return head.getNext();
        }

    }

    public static Node<Integer> evenToFront(Node<Integer> head) {
        Node<Integer> current = head;
        Node<Integer> next;

        while (current.hasNext()) {

            // save the next node in a var
            next = current.getNext();

            // if the next node is even
            if (next.getValue() % 2 == 0) {

                // remove the next node from the list
                current.setNext(next.getNext());

                // add the next node to the front of the list
                next.setNext(head);
                head = next;
            } else {
                // if the next node is not even, move on
                current = next;
            }
        }

        return head;
    }

    public static boolean isPalindromeFromStart(Node<Integer> head, int n) {
        Node<Integer> back = head;

        if (n < 0) {
            return true;
        }

        for (int i = 1; i < n; i++) {
            if (!back.hasNext()) {
                return false;
            }
            back = back.getNext();
        }

        return back.getValue() == head.getValue() && isPalindromeFromStart(head.getNext(), n - 2);
    }

    public static boolean isPalindrom(Node<Integer> head, int n) {
        Node<Integer> current = head;

        while (current != null) {
            if (isPalindromeFromStart(current, n)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    public static Node<Integer> removeList(Node<Integer> list, Node<Integer> toRemove) {
        Node<Integer> current = list;
        Node<Integer> prev = null;
        Node<Integer> rmPtr = toRemove;

        while (current != null) {
            if (current.getValue() == rmPtr.getValue()) {
                rmPtr = rmPtr.getNext();
                if (rmPtr == null) {
                    if (prev == null) {
                        return current.getNext();
                    } else {
                        prev.setNext(current.getNext());
                    }
                    return list;
                }
            } else {
                rmPtr = toRemove;
                prev = current;
            }
            current = current.getNext();
        }

        return list;
    }

    // lst 1->2->3->4->5->6->7->8->9->1
    // lst2 1->2->3->4->5->6->7->8->9->1 means the number 1234567891
    public static Node<Integer> sum(Node<Integer> list1, Node<Integer> list2) {
        list1 = reverse(list1);
        list2 = reverse(list2);

        Node<Integer> ret = new Node<>(0);
        Node<Integer> last = ret;

        while (list1 != null && list2 != null) {
            int sum = list1.getValue() + list2.getValue();
            if (last.hasNext()) {
                sum += last.getNext().getValue();
            }
            last.setNext(new Node<>(sum % 10));
            last = last.getNext();
            if (sum > 9) {
                last.setNext(new Node<>(1));
            }
            list1 = list1.getNext();
            list2 = list2.getNext();
        }
        if (list1 != null) {
            last.setNext(list1);
        }
        if (list2 != null) {
            last.setNext(list2);
        }

        return reverse(ret.getNext());
    }

    public static Node<Integer> mulList(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> ptr1, ptr2, l3, ptr3;
        ptr1 = l1;
        ptr2 = reverse(l2);
        l3 = new Node<>(-1);
        ptr3 = l3;

        while (ptr1 != null && ptr2 != null) {
            ptr3.setNext(ptr1);
            ptr1 = ptr1.getNext();
            ptr3 = ptr3.getNext();
            ptr3.setNext(ptr2);
            ptr2 = ptr2.getNext();
            ptr3 = ptr3.getNext();
        }
        return l3.getNext();
    }

    public static Node<Integer> mulList2(Node<Integer> l1, Node<Integer> l2) {
        l1 = reverse(l1);
        var l3 = new Node<>(l2.getValue());
        l2 = l2.getNext();
        l3 = new Node<>(l1.getValue(), l3);
        l1 = l1.getNext();
        while (l1 != null) {
            l3 = new Node<>(l2.getValue(), l3);
            l2 = l2.getNext();
            l3 = new Node<>(l1.getValue(), l3);
            l1 = l1.getNext();
        }
        return l3;
    }
}
