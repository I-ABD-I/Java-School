package utils;

import java.util.Comparator;

@SuppressWarnings("unused")
public class QueueUtils {
  public static <T> Queue<T> build(T[] arr) {
    Queue<T> queue = new Queue<>();
    for (T t : arr) queue.insert(t);
    return queue;
  }

  public static <T> void clear(Queue<T> queue) {
    while (!queue.isEmpty()) queue.remove();
  }


  public static <T> Queue<T> copy(Queue<T> queue) {
    Queue<T> temp = new Queue<>();
    Queue<T> copy = new Queue<>();
    while (!queue.isEmpty()) {
      temp.insert(queue.head());
      copy.insert(queue.remove());
    }
    while (!temp.isEmpty()) queue.insert(temp.remove());
    return copy;
  }

  public static <T> Queue<T> reverse(Queue<T> queue) {
    Stack<T> temp = new Stack<>();
    while (!queue.isEmpty()) temp.push(queue.remove());
    while (!temp.isEmpty()) queue.insert(temp.pop());
    return queue;
  }

  public static <T> int count(Queue<T> queue, T item) {
    int count = 0;
    Queue<T> temp = new Queue<>();
    while (!queue.isEmpty()) {
      if (queue.head().equals(item)) count++;
      temp.insert(queue.remove());
    }
    while (!temp.isEmpty()) queue.insert(temp.remove());
    return count;
  }

  public static <T> void removeItems(Queue<T> queue, T item) {
    Queue<T> temp = new Queue<>();
    while (!queue.isEmpty()) {
      if (!queue.head().equals(item)) temp.insert(queue.remove());
      else queue.remove();
    }
    while (!temp.isEmpty()) queue.insert(temp.remove());
  }


  public static <T> T min(Queue<T> queue, Comparator<? super T> comparator) {
    T min = queue.head();
    Queue<T> temp = new Queue<>();
    while (!queue.isEmpty()) {
      if (comparator.compare(queue.head(), min) < 0) min = queue.head();
      temp.insert(queue.remove());
    }
    while (!temp.isEmpty()) {
      if (!temp.head().equals(min)) queue.insert(temp.remove());
      else temp.remove();
    }
    return min;
  }

  public static <T extends Comparable<? super T>> T min(Queue<T> queue) {
    return min(queue, Comparator.naturalOrder());
  }

  public static <T> T max(Queue<T> queue, Comparator<? super T> comparator) {
    return min(queue, comparator.reversed());
  }

  public static <T extends Comparable<? super T>> T max(Queue<T> queue) {
    return min(queue, Comparator.reverseOrder());
  }
}
