package Chapter04;

import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while (true) {
            System.out.println("현재 데이터 수 : " + s.size() + "/" + s.capacity());
            System.out.print("(1)푸시   (2)팝   (3)피크   (4)덤프   (5)isEmpty   (6)isFull   (7)clear   (0)종료 : ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            boolean tOrF;
            switch (menu) {
                case 1:
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는  " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;

                case 5:
                    tOrF = s.isEmpty();
                    if(tOrF == true)
                        System.out.println("스택이 비어있습니다.");
                    else
                        System.out.println("스택이 비어있지 않습니다.");
                    break;

                case 6:
                    tOrF = s.isFull();
                    if(tOrF == true)
                        System.out.println("스택이 가득 차있습니다.");
                    else
                        System.out.println("스택이 가득 차있지 않습니다.");
                    break;

                case 7:
                    s.clear();
                    break;
            }
        }
    }
}
