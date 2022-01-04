package Chapter04;

import java.util.Scanner;

public class IntDequeTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntDeque q = new IntDeque(10);

        while (true) {
            System.out.println("현재 데이터 수 : " + q.size() + "/" + q.capacity());
            System.out.print("(1)인큐   (2)디큐   (3)피크   (4)덤프   (5)검색   (0)종료 : ");
            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            int selec;
            switch (menu) {

                case 1:
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    System.out.print("(1)A   (2)B : ");
                    selec = stdIn.nextInt();
                    try {
                        if (selec == 1)
                            q.enqueA(x);
                        else
                            q.enqueB(x);
                    } catch (IntDeque.OverflowIntDequeException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2:
                    System.out.print("(1)A   (2)B : ");
                    selec = stdIn.nextInt();
                    try {
                        if (selec == 1)
                            x = q.dequeA();
                        else
                            x = q.dequeB();
                        System.out.println("Dequeue 값 : " + x);
                    } catch (IntDeque.EmptyIntDequeException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 3:
                    System.out.print("(1)A   (2)B : ");
                    selec = stdIn.nextInt();
                    try {
                        if (selec == 1)
                            x = q.peekA();
                        else
                            x = q.peekB();
                        System.out.println("Peek 값 : " + x);
                    } catch (IntDeque.EmptyIntDequeException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 4:
                    q.dump();
                    break;

                case 5:
                    int index;
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    index = q.indexOfA(x);
                    System.out.println("q[" + index + "]에 있습니다.");
                    break;
            }
        }
    }
}
