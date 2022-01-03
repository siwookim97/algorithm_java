package Chapter04;

import java.util.Scanner;

public class IntAryQeueu {
    private int max;
    private int num;
    private int[] que;

    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {
        }
    }

    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {
        }
    }

    public IntAryQeueu(int capacity) {
        max = capacity;
        int num = 0;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enqueue(int x) throws OverflowIntQueueException {
        if (num >= max) {
            throw new OverflowIntQueueException();
        }
        return que[num++] = x;
    }

    public int dequeue() throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }
        int x = que[0];
        for (int i = 1; i < num; i++) {
            que[i - 1] = que[i];
        }
        num--;
        return x;
    }

    public void print() {
        for (int i = 0; i < num; i++) {
            System.out.print(que[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntAryQeueu q = new IntAryQeueu(10);

        while (true) {
            int menu;
            System.out.println(q.num + "/" + q.max);
            System.out.print("(1)Enqueue   (2)Dequque   (3)Print   (0)break : ");
            menu = stdIn.nextInt();
            if(menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        q.enqueue(x);
                    } catch (OverflowIntQueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = q.dequeue();
                        System.out.println("dequeue 데이터는 " + x + "입니다.");
                    } catch (EmptyIntQueueException e) {
                        System.out.println("큐가 비어있습니다.");
                    }
                    break;

                case 3:
                    q.print();
                    break;
            }
        }
    }
}
