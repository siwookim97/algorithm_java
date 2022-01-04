package Chapter04;

public class IntDeque {
    private int num;
    private int max;
    private int front;
    private int rear;
    private int[] que;

    public class EmptyIntDequeException extends RuntimeException {
        public EmptyIntDequeException() {
        }
    }

    public class OverflowIntDequeException extends RuntimeException {
        public OverflowIntDequeException() {
        }
    }

    public IntDeque(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enqueA(int x) throws OverflowIntDequeException {
        if (num >= max)
            throw new OverflowIntDequeException();
        que[rear++] = x;
        num++;
        if (rear == max)
            rear = 0;
        return x;
    }

    public int enqueB(int x) throws OverflowIntDequeException {
        if (num >= max)
            throw new OverflowIntDequeException();
        if (front == 0)
            front = max;
        que[front] = x;
        num++;
        return x;
    }

    public int dequeA() throws EmptyIntDequeException {
        if (num <= 0)
            throw new EmptyIntDequeException();
        int x = que[front++];
        num--;
        if (front == max)
            front = 0;
        return x;
    }

    public int dequeB() throws EmptyIntDequeException {
        if (num <= 0)
            throw new EmptyIntDequeException();
        if (rear < 0)
            rear = max;
        int x = que[0];
        num--;
        return x;
    }

    public int peekA() throws EmptyIntDequeException {
        if (num <= 0)
            throw new EmptyIntDequeException();
        return que[front];
    }

    public int peekB() throws EmptyIntDequeException {
        if (num <= 0)
            throw new EmptyIntDequeException();
        return (rear == 0) ? que[max] : que[rear - 1];
    }

    public int indexOfA(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (que[idx] == x)
                return idx;
        }
        return -1;
    }

    public int indexOfB(int x) {
        for (int i = num - 1; i >= 0; i--) {
            int idx = (i + front) % max;
            if (que[idx] == x)
                return idx;
        }
        return -1;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public void clear() {
        num = rear = front = 0;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= max;
    }

    public void dump() {
        if (num <= 0)
            System.out.println("큐가 비어있습니다.");
        else {
            for (int i = 0; i < num; i++) {
                System.out.print(que[(i + front) % max] + " ");
            }
            System.out.println();
        }
    }
}
