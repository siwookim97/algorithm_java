package Chapter04;

public class GQueue<E> {
    private int max;
    private int num;
    private int front;
    private int rear;
    private E[] que;

    public static class EmptyGenericQueueException extends RuntimeException {
        public EmptyGenericQueueException() {
        }
    }

    public static class OverflowGenericQueueException extends RuntimeException {
        public OverflowGenericQueueException() {
        }
    }

    public GQueue(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = (E[]) new Object[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public E enqueue(E x) throws OverflowGenericQueueException {
        if (num >= max) throw new OverflowGenericQueueException();
        que[rear++] = x;
        num++;
        if (rear == max)
            rear = 0;
        return x;
    }

    public E dequeue() throws EmptyGenericQueueException {
        if (num <= 0) throw new EmptyGenericQueueException();
        E x = que[front++];
        num--;
        if (front == max)
            front = 0;
        return x;
    }

    public E peek() throws EmptyGenericQueueException {
        if (num <= 0) throw new EmptyGenericQueueException();
        return que[front];
    }

    public int indexOf(E x) {
        for (int i = 0; i < num; i++) {
            if (x == que[(i + front) % max])
                return (i + front) % max;
        }
        return -1;
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= max;
    }

    public void dump() {
        if (num <= 0) {
            System.out.println("큐가 비어있습니다.");
        }
        else {
            for (int i = 0; i < num; i++) {
                System.out.print(que[(i + front) % max] + " ");
            }
        }
        System.out.println();
    }
}
