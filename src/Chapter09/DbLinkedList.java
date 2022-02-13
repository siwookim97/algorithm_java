package Chapter09;

import java.util.Comparator;

public class DbLinkedList<E> {

    class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        Node() { // 앞 뒤가 없는 자기 자신을 가르키는 노드를 생성
            data = null;
            prev = next = this;
        }

        Node(E obj, Node<E> prev, Node<E> next) {
            data = obj;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> crnt;

    public DbLinkedList() {
        head = crnt = new Node<E>();
    }

    public boolean isEmpty() {
        return head.next == head;
    }

    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head.next;

        while (ptr != head) {
            if (c.compare(obj, ptr.data) == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    // 선택 노드를 출력하는 printCurrentNode 메서드
    public void printCurrentNode() {
        if (isEmpty())
            System.out.println("선택 노드가 없습니다.");
        else
            System.out.println(crnt.data);
    }

    // 모든 노드를 출력하는 dump 메서드
    public void dump() {
        Node<E> ptr = head.next;

        while (ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }

    // 모든 노드를 거꾸로 출력하는 dumpReverse 메서드
    public void dumpReverse() {
        Node<E> ptr = head.prev;

        while (ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.prev;
        }
    }

    // 선택 노드를 하나 뒤쪽으로 이동
    public boolean next() {
        if (isEmpty() || crnt.next == head)
            return false;
        crnt = crnt.next;
        return true;
    }

    // 선택 노드를 하나 앞쪽으로 이동
    public boolean prev() {
        if (isEmpty() || crnt.prev == head)
            return false;
        crnt = crnt.prev;
        return true;
    }

    // 선택 노드의 바로 뒤에 노드를 삽입
    public void add(E o) {
        Node<E> node = new Node<E>(o, crnt, crnt.next);
        crnt.next = crnt.next.prev = node;
        crnt = node;
    }

    public void addFirst(E o) {
        crnt = head;
        add(o);
    }

    public void addLast(E o) {
        crnt = head.prev;
        add(o);
    }

    public void removeCurrentNode() {
        if (!isEmpty()) {
            crnt.prev.next = crnt.next;
            crnt.next.prev = crnt.prev;
            crnt = crnt.prev;
            if (crnt == head) crnt = head.next;
        }
    }

    // 노드 p를 삭제
    public void remove(Node p) {
        Node<E> ptr = head.next;

        while (ptr != head) {
            if (ptr == p) {
                crnt = p;
                removeCurrentNode();
                break;
            }
            ptr = ptr.next;
        }
    }

    // 머리 노드를 삭제
    public void removeFirst() {
        crnt = head.next;
        removeCurrentNode();
    }

    // 꼬리 노드를 삭제
    public void removeLast() {
        crnt = head.prev;
        removeCurrentNode();
    }

    // 모든 노드를 삭제
    public void clear() {
        while (!isEmpty())
            removeFirst();
    }

    // 서로 같은 노드를 찾아 모두 삭제하는 메서드
    public void purge(Comparator<? super E> c) {
        Node<E> ptr = head.next;
        Node<E> pre = head.next.next;
        int cnt = 0;

        while (ptr != head) {
            while (pre != head) {
                if (c.compare(pre.data, ptr.data) == 0) {
                    remove(pre);
                    cnt = 1;
                }
                pre = pre.next;
            }
            if (cnt == 1) remove(ptr);
            ptr = ptr.next;
            pre = ptr.next;
            cnt = 0;
        }
        crnt = head.next;
    }

    // 머리에서부터 점프하는 메서드
    public E retrieve(int n) {
        Node<E> ptr = head.next;
        int cnt = n;

        if (n == 0)
            return ptr.data;
        while (ptr != head || cnt > 0) {
            cnt--;
            ptr = ptr.next;
            crnt = ptr;

            if (cnt == 0) {
                return ptr.data;
            }
            crnt = head.next;
        }
        return null;
    }
}
