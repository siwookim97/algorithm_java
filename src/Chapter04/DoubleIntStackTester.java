package Chapter04;

import java.util.Scanner;

public class DoubleIntStackTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        DoubleIntStack s = new DoubleIntStack(64);

        while (true) {
            System.out.println("현재 데이터 수 : " + (s.sizeA() + s.sizeB()) + "/" + s.capacity());
            System.out.print("(1)푸시   (2)팝   (3)피크   (4)덤프   (5)isEmpty   (6)isFull   (7)clear   (8)indexOf   (0)종료 : ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            int y;
            boolean tOrF;
            switch (menu) {
                case 1:
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    System.out.print("(1)A스택   (2)B스택 : ");
                    y = stdIn.nextInt();
                    try {
                        if(y == 1)
                            s.pushA(x);
                        else
                            s.pushB(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    System.out.print("(1)A스택   (2)B스택 : ");
                    y = stdIn.nextInt();
                    try {
                        if(y == 1)
                            x = s.popA();
                        else
                            x = s.popB();
                        System.out.println("팝한 데이터는  " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 3:
                    System.out.print("(1)A스택   (2)B스택 : ");
                    y = stdIn.nextInt();
                    try {
                        if(y == 1)
                            x = s.peekA();
                        else
                            x = s.peekB();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 4:
                    System.out.print("(1)A스택   (2)B스택 : ");
                    y = stdIn.nextInt();
                    if(y == 1)
                        s.dumpA();
                    else
                        s.dumpB();
                    break;

                case 5:
                    System.out.print("(1)A스택   (2)B스택 : ");
                    y = stdIn.nextInt();
                    if(y == 1)
                        tOrF = s.isEmptyA();
                    else
                        tOrF = s.isEmptyB();
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
                    System.out.print("(1)A스택   (2)B스택 : ");
                    y = stdIn.nextInt();
                    if(y == 1)
                        s.clearA();
                    else
                        s.clearB();
                    break;

                case 8:
                    System.out.print("찾고자 하는 데이터 : ");
                    x = stdIn.nextInt();
                    System.out.print("(1)A스택   (2)B스택 : ");
                    y = stdIn.nextInt();
                    if(y == 1)
                        s.indexOfA(x);
                    else
                        s.indexOfB(x);
                    if(x == -1) System.out.println("찾고자 하는 데이터가 없습니다.");
                    else System.out.println("찾고자 하는 데이터가 stk[" + x + "]에 있습니다.");
            }
        }
    }
}
