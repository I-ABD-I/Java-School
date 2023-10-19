package utils;

public class Stack<T> {
  private Node<T> head;


  public Stack() {
    this.head = null;
  }

  public void push(T x) {
    Node<T> temp = new Node<T>(x);
    temp.setNext(head);
    head = temp;
  }

  public T pop() {
    T x = head.getValue();
    head = head.getNext();
    return x;
  }

  public T top() {
    return head.getValue();
  }

  public boolean isEmpty() {
    return head == null;
  }

  public String toString() {
    if (this.isEmpty()) return "[]";
    Stack<T> temp = new Stack<T>();
    while (!this.isEmpty()) temp.push(this.pop());
    StringBuilder s = new StringBuilder("[");
    while (!temp.isEmpty()) {
      s.append(temp.top()).append(", ");
      this.push(temp.pop());
    }
    s = new StringBuilder(s.substring(0, s.length() - 2) + "]");
    return s.toString();
  }

}

