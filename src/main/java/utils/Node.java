package utils;

public class Node<T> {
    // Fields
    private T value;
    private Node<T> next;

    
    // Methods
    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public Node() {
        this.next = null;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return (this.next != null);
    }

    public String toString() {
        if (this.next == null) return this.value + "-->Null";
        return this.value + "-->" + this.next;


    }
}



