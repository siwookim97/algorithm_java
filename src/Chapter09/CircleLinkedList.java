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
        if (head != null) {
            if (head == tail)
                head = tail = crnt = null;
            else {
                Node<E> ptr = head.next;
                head = crnt = ptr;
                tail.next = head;
            }
        }
    }

    public void removeLast() {
        if (head != null) {
            if (head == tail)
                head = tail = crnt = null;
            else {
                Node<E> ptr1 = head;  // 제일 마지막 노드
                Node<E> ptr2 = head;  // 제일 마지막 노드의 바로 앞

                while (ptr1.next != head) {
                    ptr2 = ptr1;
                    ptr1 = ptr1.next;
                }
                ptr2.next = head;
                tail = crnt = ptr2;
            }
        }
    }

    public void remove(Node p) {
        if (head != null) {
            if (head == tail)
                removeFirst();
            else {
                Node<E> ptr = head;

                while (ptr.next != p) {
                    ptr = ptr.next;
                    if (ptr == head) return;
                }
                ptr.next = p.next;
            }
        }
    }

    public void removeCurrentNode() {
        remove(crnt);
    }

    public void clear() {
        head = crnt = tail = null;
    }

    public boolean next() {
        return true;
    }

    public void printCurrentNode() {
        if (crnt == null)
            System.out.println("선택한 노드가 없습니다.");
        else
            System.out.println(crnt.data);
    }

    public void dump() {
        Node<E> ptr = head;

        while (ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }


}
