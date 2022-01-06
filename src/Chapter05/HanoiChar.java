package Chapter05;

import java.util.Scanner;

public class HanoiChar {
    static String[] bar = {"A기둥", "B기둥", "C기둥"};

    static void move(int no, int x, int y) {
        if (no > 1)
            move(no - 1, x, 6 - x - y);

        System.out.println("원반[" + no + "]을" + bar[x - 1] + "기둥에서 " + bar[y - 1] + "기둥으로 옮김");

        if (no > 1)
            move(no - 1, 6 - x - y, y);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반개수 : ");
        int n = stdIn.nextInt();

        move(n, 1 , 3);
    }


}
