package utils;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LinkedListUtils {

    @SafeVarargs
    public static <T> Node<T> build(T... values) {
        Node<T> head = new Node<>(values[0]);
        Node<T> current = head;
        for (int i = 1; i < values.length; i++) {
            current.setNext(current = new Node<>(values[i]));
        }
        return head;
    }

    public static <T> int length(Node<T> head) {
        int length = 0;

        while (head != null) {
            length++;
            head = head.getNext();
        }

        return length;
    }

    public static <T> Node<T> get(Node<T> head, int index) {
        int i = 0;

        while (head != null && i < index) {
            head = head.getNext();
            i++;
        }

        return head;
    }

    public static <T> T getLast(Node<T> head) {
        while (head != null && head.getNext() != null)
            head = head.getNext();

        return head.getValue();
    }

    public static <T> void apply(Node<T> head, Function<T, T> function) {
        while (head != null) {
            head.setValue(function.apply(head.getValue()));
            head = head.getNext();
        }
    }

    public static <T, R> Node<R> map(Node<T> head, Function<T, R> function) {
        if (head == null)
            return null;
        return new Node<>(function.apply(head.getValue()), map(head.getNext(), function));
    }

    public static <T> Node<T> filter(Node<T> head, Function<T, Boolean> predicate) {
        if (head == null)
            return null;
        if (predicate.apply(head.getValue()))
            return new Node<>(head.getValue(), filter(head.getNext(), predicate));
        return filter(head.getNext(), predicate);
    }

    public static <T, R> R reduce(Node<T> head, BiFunction<R, T, R> function, R inital) {
        if (head == null)
            return inital;
        return reduce(head.getNext(), function, function.apply(inital, head.getValue()));
    }

    public static <T> T min(Node<T> head, Comparator<T> comparator) {
        if (head == null)
            return null;
        return reduce(head, (x, y) -> comparator.compare(x, y) < 0 ? x : y, head.getValue());
    }

    public static <T> T max(Node<T> head, Comparator<T> comparator) {
        return min(head, comparator.reversed());
    }

    public static <T> Node<T> removeAll(Node<T> head, T value) {
        return filter(head, (x) -> !x.equals(value));
    }

}
