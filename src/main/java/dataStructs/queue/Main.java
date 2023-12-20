package dataStructs.queue;

import utils.Queue;
import utils.QueueUtils;

@SuppressWarnings("unused")
public class Main {


  public static void queueMain() {
    Queue<Integer> queue = QueueUtils.build(1, 2, 3, 4, 5, 6, 7, 8, 9);
    print(queue);
    System.out.println("Max: " + QueueUtils.max(queue));
    System.out.println("SecondMax: " + secondMax(queue));
    System.out.println("Length: " + QueueUtils.length(queue));
    System.out.println("Sum: " + QueueUtils.sum(queue));
    System.out.println("Average: " + QueueUtils.average(queue));

    queue = QueueUtils.build(9, 8, 4, 2, 3, 4, 9, 9, 2, 3);
    System.out.println("\n" + queue);
    moveBigToEnd(queue);
    System.out.println("Max to end: " + queue);

    queue = QueueUtils.build(5, 1, 2, 3, 4, 6, 7, 8, 9);
    System.out.println("\n" + queue);
    splitUsingFirst(queue);
    System.out.println("First Item Split: " + queue);

    queue = QueueUtils.build(1, 1, 2, 3, 2, 2, 2, 4, 5, 2, 6, 7, 7, 8, 8, 8, 8, 8, 8);
    System.out.println("\n" + queue);
    System.out.println("Max Sequence: " + maxSequence(queue));

    queue = QueueUtils.build(1, 2, 3, 4, 5, 6, 7, 8, 9);
    System.out.println("\n" + queue);
    System.out.println("No diff bigger then 10: " + isNoDiffBigger(queue, 10));
    System.out.println("No diff bigger then 4: " + isNoDiffBigger(queue, 4));
    QueueUtils.reverse(queue);
    System.out.println("reversed: " + queue);

    queue = QueueUtils.build(1, 2, 3, 4, 5, 6, 7, 8, 9);
    System.out.println("\n" + queue);
    reverseDuo(queue);
    System.out.println("reversed duo: " + queue);

    queue = QueueUtils.build(2, 3, 5, 3, 2, 1, 5, 2);
    System.out.println("\n" + queue);
    sortThirds(queue);
    System.out.println("sorted thirds: " + queue);

    queue = QueueUtils.build(2, 2, 3, 3, 5, 6, 7, 3, 1, 13, 3, 7, 8);
    System.out.println("\n" + queue);
    System.out.println("sorted: " + QueueUtils.sort(queue));

    queue = QueueUtils.build(1, 2, 3, 4, 5, 6, 7, 8, 9);
    System.out.println("\n" + queue);
    System.out.println("get(3): " + get(queue, 3));
    cycleForward(queue, 3);
    System.out.println("cycled forward(3): " + queue);
    cycleBackward(queue, 3);
    System.out.println("cycled backward(3): " + queue);

    queue = QueueUtils.build(64, 32, 16, 8, 4, 2, 1);
    System.out.println("\n" + queue);
    System.out.println("Bigger then all after: " + countItemsBiggerThenAllAfter(queue));

    queue = QueueUtils.build(65, 68, 42, 92, 95, 54, 24, 87, 26, 51);
    System.out.println("\n" + queue);
    System.out.println("Bigger then one after: " + countItemsBiggerThenOneAfter(queue));
    System.out.println("Bigger then one before: " + countItemsBiggerThenOneBefore(queue));
  }

  public static <T> void print(Queue<T> queue) {
    // Basically toString() but whatever
    var temp = QueueUtils.copy(queue);
    StringBuilder str = new StringBuilder("[");
    while (!temp.isEmpty()) {
      str.append(temp.remove()).append(", ");
    }
    System.out.println(str.substring(0, str.length() - 2) + ']');
  }

  public static int secondMax(Queue<Integer> queue) {
    int max = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;

    var temp = QueueUtils.copy(queue);
    while (!temp.isEmpty()) {
      if (temp.head() > max) {
        secondMax = max;
        max = temp.head();
      } else if (temp.head() > secondMax) {
        secondMax = temp.head();
      }
      temp.remove();
    }


    return secondMax;
  }

  public static Queue<Integer> queueByRarity(Queue<Integer> queue) {
    Queue<Integer> ret = new Queue<>();

    while (!queue.isEmpty()) {
      int item = queue.remove();
      int count = QueueUtils.count(queue, item);
      QueueUtils.removeItems(queue, item);
      ret.insert(item);
      ret.insert(count + 1);
    }

    return ret;
  }

  public static void moveBigToEnd(Queue<Integer> queue) {
    var temp = new Queue<Integer>();
    var maxQueue = new Queue<Integer>();

    int max = QueueUtils.maxRemove(queue);
    maxQueue.insert(max);

    while (!queue.isEmpty()) {
      if (queue.head() == max) maxQueue.insert(queue.remove());
      else temp.insert(queue.remove());
    }

    while (!temp.isEmpty()) queue.insert(temp.remove());
    while (!maxQueue.isEmpty()) queue.insert(maxQueue.remove());
  }

  public static void splitUsingFirst(Queue<Integer> queue) {
    int first = queue.remove();

    var big = new Queue<Integer>();
    var small = new Queue<Integer>();

    while (!queue.isEmpty()) {
      if (queue.head() > first) big.insert(queue.remove());
      else small.insert(queue.remove());
    }

    while (!small.isEmpty()) queue.insert(small.remove());
    queue.insert(first);
    while (!big.isEmpty()) queue.insert(big.remove());

  }

  public static int maxSequence(Queue<Integer> queue) {
    var temp = QueueUtils.copy(queue);
    int maxSeq = 0;
    int seq = 1;
    int prev = temp.remove();

    while (!temp.isEmpty()) {
      if (temp.head() == prev) seq++;
      else {
        if (seq > maxSeq) maxSeq = seq;
        seq = 1;
      }

      prev = temp.remove();
    }

    return Math.max(seq, maxSeq);
  }

  public static boolean isNoDiffBigger(Queue<Integer> queue, int diff) {
    var temp = QueueUtils.copy(queue);
    while (!temp.isEmpty()) {
      var temp2 = QueueUtils.copy(temp);
      while (!temp2.isEmpty()) {
        if (Math.abs(temp2.remove() - temp.head()) > diff) return false;
      }
      temp.remove();
    }
    return true;
  }

  public static void reverseDuo(Queue<Integer> queue) {
    var temp = new Queue<Integer>();
    var temp2 = new Queue<Integer>();
    while (!queue.isEmpty()) {
      temp.insert(queue.remove());
      if (!queue.isEmpty()) temp2.insert(queue.remove());
    }
    while (!temp2.isEmpty()) {
      queue.insert(temp2.remove());
      queue.insert(temp.remove());
    }
    while (!temp.isEmpty()) queue.insert(temp.remove());
  }

  public static void sortThirds(Queue<Integer> queue) {
    var temp = new Queue<Integer>();
    var thirds = new Queue<Integer>();
    int count = 0;

    while (!queue.isEmpty()) {
      if (count < 3) {
        thirds.insert(queue.remove());
        count++;
      } else {
        thirds = QueueUtils.sort(thirds);
        while (!thirds.isEmpty()) temp.insert(thirds.remove());
        count = 0;
      }
    }

    thirds = QueueUtils.sort(thirds);
    while (!thirds.isEmpty()) temp.insert(thirds.remove());


    while (!temp.isEmpty()) queue.insert(temp.remove());
  }

  public static <T> T get(Queue<T> queue, int index) {
    var temp = QueueUtils.copy(queue);
    while (index > 0) {
      temp.remove();
      index--;
    }
    return temp.remove();
  }

  public static void cycleForward(Queue<Integer> queue, int k) {
    while (!queue.isEmpty() && k > 0) {
      queue.insert(queue.remove());
      k--;
    }
  }

  public static void cycleBackward(Queue<Integer> queue, int k) {
    QueueUtils.reverse(queue);
    cycleForward(queue, k);
    QueueUtils.reverse(queue);
  }

  public static int countItemsBiggerThenAllAfter(Queue<Integer> queue) {
    int sum = (int) QueueUtils.sum(queue);
    int count = 0;
    var temp = QueueUtils.copy(queue);
    while (!temp.isEmpty()) {
      sum -= temp.head();
      if (temp.remove() > sum) count++;
    }

    return count;
  }

  public static int countItemsBiggerThenOneAfter(Queue<Integer> queue) {
    int count = 0;
    var temp = QueueUtils.copy(queue);
    while (!temp.isEmpty()) {
      if (temp.remove() > (!temp.isEmpty() ? temp.head() : Integer.MAX_VALUE)) count++;
    }

    return count;
  }

  public static int countItemsBiggerThenOneBefore(Queue<Integer> queue) {
    var temp = QueueUtils.copy(queue);
    QueueUtils.reverse(temp);
    return countItemsBiggerThenOneAfter(temp);
  }
}
