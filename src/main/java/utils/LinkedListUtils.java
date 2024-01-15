package utils;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LinkedListUtils {

    /**
     * Builds a linked list from an array.
     *
     * @param values the array to build the linked list from
     * @return the linked list containing the elements from the array
     */
    @SafeVarargs
    public static <T> Node<T> build(T... values) {
        Node<T> head = new Node<>(values[0]);
        Node<T> current = head;
        for (int i = 1; i < values.length; i++) {
            current.setNext(current = new Node<>(values[i]));
        }
        return head;
    }

    /**
     * Returns the length of the linked list
     *
     * @param <T>  type
     * @param head
     * @return the length of the linked list
     */
    public static <T> int length(Node<T> head) {
        int length = 0;

        while (head != null) {
            length++;
            head = head.getNext();
        }

        return length;
    }

    /**
     * Gets the element at the given index
     *
     * @param <T>   type
     * @param head
     * @param index
     * @return element at the given index
     */
    public static <T> Node<T> get(Node<T> head, int index) {
        int i = 0;

        while (head != null && i < index) {
            head = head.getNext();
            i++;
        }

        return head;
    }

    /**
     * Finds the first element in the list that matches the predicate
     *
     * @param <T>  type
     * @param head
     * @return last value in the list
     */
    public static <T> T getLast(Node<T> head) {
        while (head != null && head.getNext() != null)
            head = head.getNext();

        return head.getValue();
    }

    /**
     * Applys function to each element in the list
     *
     * @param <T>      type
     * @param head     list
     * @param function function to apply
     */
    public static <T> void apply(Node<T> head, Function<T, T> function) {
        while (head != null) {
            head.setValue(function.apply(head.getValue()));
            head = head.getNext();
        }
    }

    /**
     * Maps the list to a new list
     *
     * @param <T>      type
     * @param <R>      return type
     * @param head     list
     * @param function function to map
     * @return new list with function applied to each element
     */
    public static <T, R> Node<R> map(Node<T> head, Function<T, R> function) {
        if (head == null)
            return null;
        return new Node<>(function.apply(head.getValue()), map(head.getNext(), function));
    }

    /**
     * Filters the list based on the predicate
     *
     * @param <T>       type
     * @param head      list
     * @param predicate predicate to filter
     * @return new list with elements that pass the predicate
     */
    public static <T> Node<T> filter(Node<T> head, Function<T, Boolean> predicate) {
        if (head == null)
            return null;
        if (predicate.apply(head.getValue()))
            return new Node<>(head.getValue(), filter(head.getNext(), predicate));
        return filter(head.getNext(), predicate);
    }

    /**
     * Reduces the list to a single value
     *
     * @param <T>      type
     * @param <R>      return type
     * @param head     list
     * @param function function to reduce
     * @param inital   inital value
     * @return reduced value
     */
    public static <T, R> R reduce(Node<T> head, BiFunction<R, T, R> function, R inital) {
        if (head == null)
            return inital;
        return reduce(head.getNext(), function, function.apply(inital, head.getValue()));
    }

    /**
     * Finds the minimum value in the list
     *
     * @param <T>        type
     * @param head       list
     * @param comparator comparator to compare elements
     * @return minimum value in the list
     */
    public static <T> T min(Node<T> head, Comparator<T> comparator) {
        if (head == null)
            return null;
        return reduce(head, (x, y) -> comparator.compare(x, y) < 0 ? x : y, head.getValue());
    }

    /**
     * Finds the maximum value in the list
     *
     * @param <T>        type
     * @param head       list
     * @param comparator comparator to compare elements
     * @return maximum value in the list
     */
    public static <T> T max(Node<T> head, Comparator<T> comparator) {
        return min(head, comparator.reversed());
    }

    /**
     * removes all elements that match the value
     *
     * @param <T>   type
     * @param head  list
     * @param value value to remove
     * @return new list with elements removed
     */
    public static <T> Node<T> removeAll(Node<T> head, T value) {
        return filter(head, (x) -> !x.equals(value));
    }

    /**
     * checks if the list contains the value
     *
     * @param <T>   type
     * @param head  list
     * @param value value to check
     * @return true if the list contains the value
     */
    public static <T> boolean contains(Node<T> head, T value) {
        if (head == null)
            return false;
        return reduce(head, (x, y) -> x || y.equals(value), false);
    }

    /**
     * Reverses the list
     *
     * @param <T>  type
     * @param head list
     * @return reversed list
     */
    public static <T> Node<T> reverse(Node<T> head) {
        if (head == null)
            return null;

        var pos = head;
        Node<T> newList = null;

        while (pos != null) {
            newList = new Node<>(pos.getValue(), newList);
            pos = pos.getNext();
        }

        return newList;
    }

    /**
     * Merges two sorted lists
     *
     * @param <T>   type
     * @param list1 list 1
     * @param list2 list 2
     * @return merged list
     */
    public static <T extends Comparable<? super T>> Node<T> sortedMerge(Node<T> list1, Node<T> list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        Node<T> result = null;
        if (list1.getValue().compareTo(list2.getValue()) < 0) {
            result = list1;
            result.setNext(sortedMerge(list1.getNext(), list2));
        } else {
            result = list2;
            result.setNext(sortedMerge(list1, list2.getNext()));
        }

        return result;
    }

    /**
     * Gets the middle element in the list
     *
     * @param <T>  types
     * @param head list
     * @return middle node
     */
    public static <T> Node<T> getMiddle(Node<T> head) {
        if (head == null) {
            return head;
        }

        Node<T> slow = head;
        Node<T> fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }

    /**
     * Sorts the list using merge sort
     *
     * @param <T>  type
     * @param head list
     * @return sorted list
     */
    public static <T extends Comparable<? super T>> Node<T> mergeSort(Node<T> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node<T> middle = getMiddle(head);
        Node<T> nextOfMiddle = middle.getNext();

        middle.setNext(null);

        Node<T> left = mergeSort(head);
        Node<T> right = mergeSort(nextOfMiddle);

        Node<T> sortedList = sortedMerge(left, right);
        return sortedList;
    }
}
