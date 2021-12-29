package Chapter03;

import java.util.Scanner;

public class BinSearch {

    static int binSearch(int[] a, int num, int key) {
        int pl = 0;
        int pr = num - 1;

        do {
            int pc = (pl + pr) / 2;
            if (a[pc] == key)
                return pc;
            else if (a[pc] > key)
                pr = pc - 1;
            else
                pl = pc + 1;
        } while (pr >= pl);

        return - 1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수를 입력 : ");
        int num = stdIn.nextInt();
        int[] a = new int[num];

        System.out.println("오름차순으로 입력하시오");
        System.out.print("a[0] :");
        a[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("a[" + i + "] :");
                a[i] = stdIn.nextInt();
            } while (a[i] <= a[i - 1]);
        }

        System.out.print("찾고자 하는 값을 입력하시오 : ");
        int key = stdIn.nextInt();
        int idx = binSearch(a, num, key);

        if (idx == -1) System.out.println("찾고자 하는 값이 없습니다.");
        else System.out.println("찾고자 하는 값이 a[" + idx + "] 에 있습니다.");
    }
}
