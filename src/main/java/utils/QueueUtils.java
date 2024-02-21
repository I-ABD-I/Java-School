package utils;

import java.util.Comparator;

public class QueueUtils {
    /**
     * Builds a new Queue from the provided items.
     *
     * @param items The items to be inserted into the queue.
     * @return A new Queue containing the provided items.
     */
    @SafeVarargs
    public static <T> Queue<T> build(T... items) {
        Queue<T> queue = new Queue<>();
        for (T t : items)
            queue.insert(t);
        return queue;
    }

    /**
     * Clears all items from the provided Queue.
     *
     * @param queue The Queue to be cleared.
     */
    public static <T> void clear(Queue<T> queue) {
        while (!queue.isEmpty())
            queue.remove();
    }

    /**
     * Creates a copy of the provided Queue.
     *
     * @param queue The Queue to be copied.
     * @return A new Queue containing the same items as the provided Queue.
     */
    public static <T> Queue<T> copy(Queue<T> queue) {
        Queue<T> temp = new Queue<>();
        Queue<T> copy = new Queue<>();
        while (!queue.isEmpty()) {
            temp.insert(queue.head());
            copy.insert(queue.remove());
        }
        while (!temp.isEmpty())
            queue.insert(temp.remove());
        return copy;
    }

    /**
     * Reverses the order of items in the provided Queue.
     *
     * @param queue The Queue to be reversed.
     */
    public static <T> void reverse(Queue<T> queue) {
        if (queue.isEmpty())
            return;
        T item = queue.remove();
        reverse(queue);
        queue.insert(item);
    }

    /**
     * Counts the occurrences of a specific item in the provided Queue.
     *
     * @param queue The Queue to be searched.
     * @param item  The item to count.
     * @return The number of occurrences of the item in the Queue.
     */
    public static <T> int count(Queue<T> queue, T item) {
        int count = 0;
        Queue<T> temp = new Queue<>();
        while (!queue.isEmpty()) {
            if (queue.head().equals(item))
                count++;
            temp.insert(queue.remove());
        }
        while (!temp.isEmpty())
            queue.insert(temp.remove());
        return count;
    }

    /**
     * Removes all occurrences of a specific item from the provided Queue.
     *
     * @param queue The Queue to remove items from.
     * @param item  The item to be removed.
     */
    public static <T> void removeItems(Queue<T> queue, T item) {
        Queue<T> temp = new Queue<>();
        while (!queue.isEmpty()) {
            if (!queue.head().equals(item))
                temp.insert(queue.remove());
            else
                queue.remove();
        }
        while (!temp.isEmpty())
            queue.insert(temp.remove());
    }

    /**
     * Removes and returns the smallest item from the provided Queue.
     *
     * @param queue      The Queue to remove the item from.
     * @param comparator The Comparator to determine the order of the items.
     * @return The smallest item from the Queue.
     */
    public static <T> T minRemove(Queue<T> queue, Comparator<? super T> comparator) {
        T min = queue.head();
        Queue<T> temp = new Queue<>();
        while (!queue.isEmpty()) {
            if (comparator.compare(queue.head(), min) < 0)
                min = queue.head();
            temp.insert(queue.remove());
        }

        int count = 0;
        while (!temp.isEmpty()) {
            if (!temp.head().equals(min) || count != 0)
                queue.insert(temp.remove());
            else {
                count++;
                temp.remove();
            }
        }
        return min;
    }

    /**
     * Removes and returns the smallest item from the provided Queue.
     *
     * @param queue The Queue to remove the item from.
     * @return The smallest item from the Queue.
     */
    public static <T extends Comparable<? super T>> T minRemove(Queue<T> queue) {
        return minRemove(queue, Comparator.naturalOrder());
    }

    /**
     * Removes and returns the largest item from the provided Queue.
     *
     * @param queue      The Queue to remove the item from.
     * @param comparator The Comparator to determine the order of the items.
     * @return The largest item from the Queue.
     */
    public static <T> T maxRemove(Queue<T> queue, Comparator<? super T> comparator) {
        return minRemove(queue, comparator.reversed());
    }

    /**
     * Removes and returns the largest item from the provided Queue.
     *
     * @param queue The Queue to remove the item from.
     * @return The largest item from the Queue.
     */
    public static <T extends Comparable<? super T>> T maxRemove(Queue<T> queue) {
        return minRemove(queue, Comparator.reverseOrder());
    }

    /**
     * Returns the smallest item from the provided Queue.
     *
     * @param queue      The Queue to get the item from.
     * @param comparator The Comparator to determine the order of the items.
     * @return The smallest item from the Queue.
     */
    public static <T> T min(Queue<T> queue, Comparator<? super T> comparator) {
        T min = queue.head();
        Queue<T> temp = new Queue<>();
        while (!queue.isEmpty()) {
            if (comparator.compare(queue.head(), min) < 0)
                min = queue.head();
            temp.insert(queue.remove());
        }
        while (!temp.isEmpty())
            queue.insert(temp.remove());
        return min;
    }

    /**
     * Returns the smallest item from the provided Queue.
     *
     * @param queue The Queue to get the item from.
     * @return The smallest item from the Queue.
     */
    public static <T extends Comparable<? super T>> T min(Queue<T> queue) {
        return min(queue, Comparator.naturalOrder());
    }

    /**
     * Returns the largest item from the provided Queue.
     *
     * @param queue      The Queue to get the item from.
     * @param comparator The Comparator to determine the order of the items.
     * @return The largest item from the Queue.
     */
    public static <T> T max(Queue<T> queue, Comparator<? super T> comparator) {
        return min(queue, comparator.reversed());
    }

    /**
     * Returns the largest item from the provided Queue.
     *
     * @param queue The Queue to get the item from.
     * @return The largest item from the Queue.
     */
    public static <T extends Comparable<? super T>> T max(Queue<T> queue) {
        return min(queue, Comparator.reverseOrder());
    }

    /**
     * Returns the length of the provided Queue.
     *
     * @param queue The Queue to get the length of.
     * @return The length of the Queue.
     */
    public static <T> int length(Queue<T> queue) {
        var temp = QueueUtils.copy(queue);
        int length = 0;
        while (!temp.isEmpty()) {
            temp.remove();
            length++;
        }

        return length;
    }

    /**
     * Returns the sum of the items in the provided Queue.
     *
     * @param queue The Queue to get the sum of.
     * @return The sum of the items in the Queue.
     */
    public static <T extends Number> double sum(Queue<T> queue) {
        var temp = QueueUtils.copy(queue);
        double sum = 0;
        while (!temp.isEmpty()) {
            sum += temp.remove().doubleValue();
        }
        return sum;
    }

    /**
     * Returns the average of the items in the provided Queue.
     *
     * @param queue The Queue to get the average of.
     * @return The average of the items in the Queue.
     */
    public static <T extends Number> double average(Queue<T> queue) {
        return sum(queue) / length(queue);
    }

    /**
     * Sorts the items in the provided Queue.
     *
     * @param queue      The Queue to sort.
     * @param comparator The Comparator to determine the order of the items.
     * @return A new Queue containing the sorted items.
     */
    public static <T> Queue<T> sort(Queue<T> queue, Comparator<? super T> comparator) {
        Queue<T> temp = QueueUtils.copy(queue);
        Queue<T> sorted = new Queue<>();
        while (!temp.isEmpty())
            sorted.insert(minRemove(temp, comparator));
        return sorted;
    }

    /**
     * Sorts the items in the provided Queue.
     *
     * @param queue The Queue to sort.
     * @return A new Queue containing the sorted items.
     */
    public static <T extends Comparable<? super T>> Queue<T> sort(Queue<T> queue) {
        return sort(queue, Comparator.naturalOrder());
    }

}
