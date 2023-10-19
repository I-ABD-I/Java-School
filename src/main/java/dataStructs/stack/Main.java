package dataStructs.stack;


import utils.Stack;
import utils.StackUtils;

@SuppressWarnings("unused")
public class Main {
  public static void stackMain() {
    Stack<Integer> stack = StackUtils.build(new Integer[]{4, 4, 4, 8});
    System.out.println(hasNumTwice(stack, 4));
  }

  public static boolean isEven(Stack<Integer> stack) {
    Stack<Integer> temp = StackUtils.copy(stack);

    while (!temp.isEmpty()) if (temp.pop() % 2 != 0) return false;

    return true;
  }

  public static int median(Stack<Integer> stack) {
    Stack<Integer> temp = StackUtils.copy(stack);

    int median = 0;
    while (!temp.isEmpty()) {
      median = StackUtils.min(temp);
      if (!temp.isEmpty()) StackUtils.max(temp);
    }

    return median;
  }

  // O(n)
  public static int duoOver10(Stack<Integer> stack) {
    Stack<Integer> temp = StackUtils.copy(stack);       // n
    int count = 0;                                      // const
    int sum = 0;                                        // const

    while (!temp.isEmpty()) {                           // n
      sum += temp.pop();                                // const
      if (!temp.isEmpty()) sum += temp.top();           // const
      if (sum > 10) count++;                            // const
      sum = 0;                                          // const
    }

    return count;                                       // const
  }


  // O(n^2)
  public static boolean isUnique(Stack<Integer> stack) {
    var temp = StackUtils.copy(stack);                                         // n

    while (!temp.isEmpty()) {                                                  // n
      if (StackUtils.contains(temp, temp.pop())) return false;     // n -> whole while n*n
    }

    return true;                                                               // const
  }

  // O(n^2)
  public static void removeCountEvenAppearances(Stack<Integer> stack) {
    Stack<Integer> temp = StackUtils.copy(stack);                           // n

    while (!temp.isEmpty()) {                                               // n
      if (StackUtils.countItems(temp, temp.top()) % 2 == 0)     // n
        StackUtils.removeItems(stack, temp.top());               // n  -> whole while n*n
      StackUtils.removeItems(temp, temp.pop());                 // n
    }

  }


  // O(n)
  public static int countFixSizedSequences(Stack<Integer> stack, int size) {
    Stack<Integer> temp = StackUtils.copy(stack);                           // n

    int count = 0;                                                          // const
    int countSequence = 1;                                                  // const
    int prev = temp.pop();                                                  // const
    while (!temp.isEmpty()) {                                               // n
      if (temp.top() == prev) countSequence++;                              // const
      else {                                                                // const
        if (countSequence == size) count++;                                 // const
        countSequence = 1;                                                  // const
      }                                                                     // const
      prev = temp.pop();                                                    // const
    }
    if (countSequence == size) count++;                                     // const


    return count;                                                           // const
  }

  // O(n*m)
  public static int countItemEqu2Items(Stack<Integer> stack, Stack<Integer> stack2) {
    Stack<Integer> temp = StackUtils.copy(stack);                           // n
    Stack<Integer> temp2 = StackUtils.copy(stack2);                         // m

    int count = 0;                                                          // const
    while (!temp.isEmpty()) {                                               // n
      boolean found = false;                                                // const
      while (!temp2.isEmpty() && !found) {                                  // m
        int sum = temp2.pop();                                              // const
        if (!temp2.isEmpty()) sum += temp2.top();                           // const
        if (sum == temp.top()) {                                            // const
          count++;                                                          // const
          found = true;                                                     // const
        }
      }
      temp.pop();                                                           // const
      temp2 = StackUtils.copy(stack2);                                      // m
    }

    return count;                                                           // const
  }

  // O(n)
  public static void removeLowHalf(Stack<Integer> stack) {
    Stack<Integer> temp = new Stack<>();                                    // const
    double avg = 0;                                                         // const
    int size = 0;                                                           // const
    while (!stack.isEmpty()) {                                              // n
      avg += stack.top();                                                   // const
      temp.push(stack.pop());                                            // const
      size++;                                                               // const
    }
    avg /= size;                                                            // const
    while (!temp.isEmpty()) {                                               // n
      if (temp.top() > avg) stack.push(temp.top());                      // const
      temp.pop();                                                           // const
    }
  }

  // O(n)
  public static void lowOfThree(Stack<Integer> stack) {
    Stack<Integer> temp = new Stack<>();                                        // const
    while (!stack.isEmpty()) {                                                  // n
      temp.push(Math.min(Math.min(stack.pop(), stack.pop()), stack.pop()));  // const
    }

    while (!temp.isEmpty()) stack.push(temp.pop());                           // n
  }

  // O(n)
  public static boolean isCrazy(Stack<Integer> stack) {
    Stack<Integer> temp = StackUtils.copy(stack);                             // n

    int count = 1;
    int prevCount = Integer.MAX_VALUE;
    int prev = temp.pop();

    while (!temp.isEmpty()) {                                                  // n
      if (temp.top() == prev) count++;
      else {
        if (count > prevCount) return false;
        prevCount = count;
        count = 1;
      }
      prev = temp.pop();
    }

    return count < prevCount;
  }

  // O(n)
  public static boolean prevBiggerThanSum(Stack<Integer> stack) {
    Stack<Integer> temp = StackUtils.copy(stack);                             // n
    double sum = StackUtils.sum(stack);

    while (!temp.isEmpty()) {                                                  // n
      if (temp.top() <= (sum -= temp.pop())) return false;
    }
    return true;
  }

  // O(n)
  public static boolean hasNumTwice(Stack<Integer> stack, int num) {
    Stack<Integer> temp = StackUtils.copy(stack);                             // n

    int count = 0;
    while (!temp.isEmpty() && count < 2) {                                      // n
      if (temp.pop() == num) count++;
    }
    return count >= 2;
  }
}