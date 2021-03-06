package Chapter09;

import java.util.Comparator;

public class AryLinkedList<E> {

    class Node<E> {
        private E data;
        private int next;
        private int dnext; // 프리 리스트 다음 커서 처음은 null으로 할당

        void set(E data, int next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E>[] n;  // 리스트 본체
    private int size;  // 리스트의 용량
    private int max;  // 사용 중인 꼬리 record
    private int head;  // 머리 노드
    private int crnt;  // 선택 노드
    private int deleted;  // free 리스트의 머리 노드
    private static final int NULL = -1;  // 다음 노드 없음 / 리스트가 가득 참


    public AryLinkedList(int capacity) {
        head = crnt = max = deleted = NULL;
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

    // 다음에 삽입하는 record의 인덱스 구함
    private int getInsertIndex() {
        if (deleted == NULL) { // 삭제할 record없음
            if (max < size)
                return ++max; // 새 record사용
            else
                return NULL;
        } else {
            int rec = deleted;
            deleted = n[rec].dnext;
            return rec;
        }
    }

    private void deleteIndex(int idx) {
        if (deleted == NULL) {
            deleted = idx;
            n[idx].dnext = NULL;
        } else {
            int rec = deleted;
            deleted = idx;
            n[idx].dnext = rec;
        }
    }

    // 노드 검색
    public E search(E obj, Comparator<? super E> c) {
        int ptr = head;
        while (ptr != NULL) {
            if (c.compare(obj, n[ptr].data) == 0) {
                crnt = ptr;
                return n[ptr].data;
            }
            ptr = n[ptr].next;
        }
        return null;
    }

    // 머리에 노드 삽입
    public void addFirst(E obj) {
        int ptr = head;
        int rec = getInsertIndex();
        if (rec != NULL) {
            head = crnt = rec;
            n[head].set(obj, ptr);
        }
    }

    public void addLast(E obj) {
        if (head == NULL)
            addFirst(obj);
        else {
            int ptr = head;
            while (n[ptr].next != NULL)
                ptr = n[ptr].next;
            int rec = getInsertIndex();
            if (rec != NULL) {
                n[ptr].next = crnt = rec;
                n[rec].set(obj, NULL);
            }
        }
    }

    public void removeFirst() {
        if (head != NULL) {
            int ptr = n[head].next;
            deleteIndex(head);
            head = crnt = ptr;
        }
    }

    public void removeLast() {
        if (head != NULL) {
            if (n[head].next == NULL)
                removeFirst();
            else {
                int ptr = head;
                int pre = head;

                while (n[ptr].next != NULL) {
                    pre = ptr;
                    ptr = n[ptr].next;
                }
                n[pre].next = NULL;
                deleteIndex(ptr);
                crnt = pre;
            }
        }
    }

    public void remove(int p) {
        if (head != NULL) {
            if (p == head)
                removeFirst();
            else {
                int ptr = head;

                while (n[ptr].next != p) {
                    ptr = n[ptr].next;
                    if (ptr == NULL) return;
                }
                n[ptr].next = NULL;
                deleteIndex(p);
                n[ptr].next = n[p].next;
                crnt = ptr;
            }
        }
    }

    public void removeCurrentNode() {
        remove(crnt);
    }

    public void clear() {
        while (head != NULL)
            removeFirst();
        crnt = NULL;
    }

    public boolean next() {
        if (crnt == NULL || n[crnt].next == NULL)
            return false;
        crnt = n[crnt].next;
        return true;
    }

    public void printCurrentNode() {
        if (crnt == NULL)
            System.out.println("선택 노드가 없습니다.");
        else
            System.out.println(n[crnt].data);
    }

    public void dump() {
        int ptr = head;

        while (ptr != NULL) {
            System.out.println(n[ptr].data);
            ptr = n[ptr].next;
        }
    }

    public void purge(Comparator<? super E> c) {
        int ptr1 = head;
        int cnt = 0;  // 중복 요소가 있는지 확인

        while (ptr1 != NULL) {
            int ptr2 = ptr1;
            ptr2 = n[ptr2].next;

            while (ptr2 != NULL) {
                if (c.compare(n[ptr1].data, n[ptr2].data) == 0) {
                    remove(ptr2);
                    cnt = 1;
                }
                ptr2 = n[ptr2].next;
                if (cnt == 1)
                    remove(ptr1);
            }

            ptr1 = n[ptr1].next;
        }
        crnt = head;
    }

    public E retrieve(int i) {
        int ptr = head;
        while (i >= 0 || ptr != NULL) {
            i--;
            ptr = n[ptr].next;
            if (i == 0) { // 정상적으로 retrieve를 마쳤을 경우
                crnt = ptr;
                return n[ptr].data;
            } else { // 원하는 값까지 가지 못했을 경우 (i의 값이 노드의 개수보다 크거나 같다)
                crnt = head;
                return null;
            }
        }
        return null;
    }
}

