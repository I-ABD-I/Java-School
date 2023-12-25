package utils;

import java.util.Comparator;

public class StackUtils {
    /**
     * Builds a stack from an array.
     *
     * @param items the array to build the stack from
     * @return the stack containing the elements from the array
     */
    @SafeVarargs
    public static <T> Stack<T> build(T... items) {
        Stack<T> stack = new Stack<>();
        for (var i : items) {
            stack.push(i);
        }
        return stack;
    }

    /**
     * Clears all elements from the given stack.
     *
     * @param stack the stack to be cleared
     */
    public static <T> void clear(Stack<T> stack) {
        while (!stack.isEmpty())
            stack.pop();
    }

    public static <T> Stack<T> copy(Stack<T> stack) {
        Stack<T> copy = new Stack<>();
        Stack<T> temp = new Stack<>();

        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }

        while (!temp.isEmpty()) {
            stack.push(temp.top());
            copy.push(temp.pop());
        }

        return copy;
    }

    /**
     * Finds and removes the minimum value from a stack.
     *
     * @param stack the stack to search for the minimum value
     * @return the minimum value found in the stack
     */
    public static <T extends Comparable<? super T>> T min(Stack<T> stack) {
        return min(stack, Comparator.naturalOrder());
    }

    /**
     * Finds and removes the minimum element from the given stack based on the
     * provided comparator.
     *
     * @param stack      the stack from which to find the minimum element
     * @param comparator the comparator used to compare elements in the stack
     * @return the minimum element found in the stack
     */
    public static <T> T min(Stack<T> stack, Comparator<? super T> comparator) {
        // init min value and temp stack
        T min = stack.pop();
        Stack<T> temp = new Stack<>();
        temp.push(min);

        // find min value
        while (!stack.isEmpty()) {
            if (comparator.compare(stack.top(), min) < 0)
                min = stack.top();
            temp.push(stack.pop());
        }

        // return stack into orig state without min
        int count = 0;
        while (!temp.isEmpty()) {
            if (!temp.top().equals(min) || count != 0)
                stack.push(temp.top());
            else {
                count++;
                temp.pop();
            }
            temp.pop();
        }
        return min;
    }

    /**
     * Finds the maximum value in a stack.
     *
     * @param stack the stack of integers to search
     * @return the maximum value in the stack
     */
    public static <T extends Comparable<? super T>> T max(Stack<T> stack) {
        return min(stack, Comparator.reverseOrder());
    }

    /**
     * Find and return the maximum value from a stack using a comparator.
     *
     * @param stack      the stack from which to find the maximum value
     * @param comparator the comparator used to compare the values in the stack
     * @return the maximum value in the stack
     */
    public static <T> T max(Stack<T> stack, Comparator<? super T> comparator) {
        return min(stack, comparator.reversed());
    }

    /**
     * Sorts a stack of elements in ascending order.
     *
     * @param stack the stack to be sorted
     * @return the sorted stack
     */
    public static <T extends Comparable<? super T>> Stack<T> sort(Stack<T> stack) {
        return sort(stack, Comparator.naturalOrder());
    }

    /**
     * Sorts the elements in the given stack in ascending order using the provided
     * comparator.
     *
     * @param stack      the stack to be sorted
     * @param comparator the comparator used to compare the elements in the stack
     * @return a new stack containing the sorted elements
     */
    public static <T> Stack<T> sort(Stack<T> stack, Comparator<? super T> comparator) {
        Stack<T> temp = copy(stack);
        Stack<T> sorted = new Stack<>();
        while (!temp.isEmpty())
            sorted.push(min(temp, comparator));
        return sorted;
    }

    /**
     * Determines whether the given item is present in the stack.
     *
     * @param stack the stack to search in
     * @param item  the item to search for
     * @return true if the item is found, false otherwise
     */
    public static <T> boolean contains(Stack<T> stack, T item) {
        var temp = StackUtils.copy(stack);
        while (!temp.isEmpty()) {
            if (temp.pop().equals(item))
                return true;
        }
        return false;
    }

    /**
     * Counts the number of occurrences of a given item in a stack.
     *
     * @param stack the stack to search for the item
     * @param item  the item to count occurrences of
     * @return the number of occurrences of the item in the stack
     */
    public static <T> int countItems(Stack<T> stack, T item) {
        int count = 0;
        var temp = StackUtils.copy(stack);
        while (!temp.isEmpty()) {
            if (temp.pop().equals(item))
                count++;
        }

        return count;
    }

    /**
     * Removes all occurrences of the specified item from the stack.
     *
     * @param stack the stack from which to remove the items
     * @param item  the item to be removed from the stack
     */
    public static <T> void removeItems(Stack<T> stack, T item) {
        var temp = new Stack<T>();
        while (!stack.isEmpty()) {
            if (!stack.top().equals(item))
                temp.push(stack.top());
            stack.pop();
        }

        while (!temp.isEmpty())
            stack.push(temp.pop());

    }

    /**
     * Sums up the elements in the given stack.
     *
     * @param stack the stack containing the elements to be summed
     * @return the sum of the elements in the stack
     */
    public static <T extends Number> double sum(Stack<T> stack) {
        var temp = StackUtils.copy(stack);
        double sum = 0;
        while (!temp.isEmpty())
            sum = sum + temp.pop().doubleValue();
        return sum;
    }

}
