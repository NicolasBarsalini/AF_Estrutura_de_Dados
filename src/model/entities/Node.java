package model.entities;

public class Node {
    Subject subject;
    Node next;
    Node prev;

    public Node(Subject subject) {
        this.subject = subject;
        this.next = null;
        this.prev = null;
    }
}
