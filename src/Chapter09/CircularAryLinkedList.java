package Chapter09;

import java.util.Comparator;

public class CircularAryLinkedList<E> {

    class Node<E> {
        private E data;
        private int next;
        private int dnext;

        void set(E data, int next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E>[] n;  // 리스트 본체
    private int size;  // 리스트의 용량
    private int max;  // 사용 중인 꼬리 record
    private int head;  // 머리 노드
    private int tail;  // 꼬리 노드
    private int crnt;  // 선택 노드
    private int deleted;  // free 리스트의 머리 노드
    private static final int NULL = -1;  // 다음 노드 없음 / 리스트가 가득 참

    public CircularAryLinkedList(int capacity) {
        head = tail = crnt = max = deleted = NULL;
        try {
            n = new Node[capacity];
            for (int i = 0; i < capacity; i++) {
                n[i] = new Node<E>();
            }
            size = capacity;
        } catch (OutOfMemoryError e) {
            size = 0;
        }
    }

    // 다음에 삽입하는 record의 인덱스를 구함
    private int getInsertIndex() {
        if (deleted == NULL) {
            if (max == size)
                return ++max;
            else
                return NULL;
        } else {
            int rec = deleted;
            deleted = n[rec].dnext;
            return rec;
        }
    }

    // record를 freeList에 등록
    private void deleteIndex(int idx) {
        if (deleted == NULL) {  // 삭제할 record가 없다
            deleted = idx;
            n[idx].dnext = NULL;
        }
        else {
            int rec = deleted;
            deleted = idx;
            n[idx].dnext = rec;
        }
    }

    public E search(E obj, Comparator<? super E> c) {
        int ptr = head;
        do {
            if (c.compare(n[ptr].data, obj) == 0) {
                crnt = ptr;
                return n[ptr].data;
            }
            ptr = n[ptr].next;
        } while (ptr != head);
        return null;
    }

    public void addFirst(E obj) {
        if (head == NULL) {
            int rec = getInsertIndex();
            if (rec != NULL) {
                head = tail = crnt = rec;
                n[head].set(obj, rec);
            }
        }
        else {
            int ptr = head;
            int rec = getInsertIndex();
            if (rec != NULL) {
                head = crnt = rec;
                n[head].set(obj, ptr);
                n[tail].next = head;
            }
        }
    }

    public void addLast(E obj) {
        if (head == NULL) {
            addFirst(obj);
        }
        else {
            int rec = getInsertIndex();
            int ptr = tail;
            if (rec != NULL) {
                n[ptr].next = crnt = rec;
                n[rec].set(obj, head);
                tail = rec;
            }
        }
    }

    public void removeFirst() {
        if (head != NULL) {
            if (head == tail) {
                deleteIndex(head);
                head = tail = crnt = NULL;
            }
            else {
                int ptr = n[head].next;
                deleteIndex(head);
                head = crnt = ptr;
                n[tail].next = ptr;
            }
        }
    }

    public void removeLast() {
        if (head != NULL) {
            if (head == tail) {
                deleteIndex(tail);
                head = tail = crnt = NULL;
            }
            else {
                int ptr1 = head;
                int ptr2 = head;

                do {
                    ptr2 = ptr1;
                    ptr1 = n[ptr1].next;
                } while (ptr1 != head);
                n[ptr2].next = head;
                deleteIndex(ptr1);
                crnt = ptr2;
            }
        }
    }

    public void remove(int p) {
        if (head != NULL) {
            if (p == head)
                removeFirst();
            else if (p == tail)
                removeLast();
            else {
                int ptr = head;

                while (n[ptr].next != p) {
                    ptr = n[ptr].next;
                    if (ptr == head)
                        return;  // 리스트에 없음
                }
                n[ptr].next = n[p].next;
                deleteIndex(p);
                crnt = ptr;
            }
        }
    }

    public void removeCurrentNode() {
        remove(crnt);
    }

    public void clear() {
        while (head != NULL) {
            removeFirst();
        }
        crnt = NULL;
    }

    public boolean next() {
        if (crnt == NULL) {
            return false;
        }
        else if (n[crnt].next == head) {
            return false;
        }
        crnt = n[crnt].next;
        return true;
        }

    public void printCurrentNode() {
        if (crnt == NULL)
            System.out.println("선택 노드가 없습니다.");
        else
            System.out.println(n[crnt].data.toString());
    }
}
