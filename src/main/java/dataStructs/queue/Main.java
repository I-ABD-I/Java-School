package dataStructs.queue;

import utils.Queue;
import utils.QueueUtils;

@SuppressWarnings("unused")
public class Main {

  public static void queueMain() {
    Queue<Integer> queue = QueueUtils.build(new Integer[]{1, 1, 1, 2, 2, 3, 2, 2, 3});
    System.out.println(queueByRarity(queue));
  }


  public static int secondMax(Queue<Integer> queue) {
    int max = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;

    while (!queue.isEmpty()) {
      if (queue.head() > max) {
        secondMax = max;
        max = queue.head();
      } else if (queue.head() > secondMax) {
        secondMax = queue.head();
      }
      queue.remove();
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

}
