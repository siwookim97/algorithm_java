package Chapter09;

import java.util.Comparator;

public class CircleLinkedList <E> {
    class Node<E> {
        private E data;
        private Node<E> next; // 다음 포인터

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head;
    private Node<E> crnt;
    private Node<E> tail;

    public CircleLinkedList() {head = crnt = tail = null;}

    public E search(E obj, Comparator<? super E> c) {
        if (head != null) {
            Node<E> ptr = head;

            do {
                if (c.compare(obj, ptr.data) == 0) {
                    crnt = ptr;
                    ptr = ptr.next;
                }
            } while (ptr != head);
        }
        return null;
    }

    public void addFirst(E obj) {
        if (head == null)
            head = tail = crnt = new Node<E>(obj);
        else {
            Node<E> ptr1 = head;
            head = crnt = new Node<E>(obj, ptr1);
            tail.next = head;
        }
    }

    public void addLast(E obj) {
        if (head == null)
            addFirst(obj);
        else {
            Node<E> ptr = tail;
            ptr.next = crnt = tail = new Node<E>(obj, head);
        }
    }

    public void removeFirst() {

    }

    public void removeLast() {

    }

    public void remove(Node p) {

    }

    public void removeCurrentNode() {
        remove(crnt);
    }

    public void clear() {

    }

    public boolean next() {
        return true;
    }

    public void printCurrentNode() {

    }

    public void dump() {

    }


}
