package Chapter03;

import java.util.Scanner;

public class BinSearchX {
    static int binSearchX(int[] a, int num, int key) {
        int pl = 0;
        int pr = num - 1;
        int idx = -1;

        do {
            int pc = (pr + pl) / 2;
            if (a[pc] == key) {
                idx = pc;
                break;
            } else if (a[pc] > key) {
                pr = pc - 1;
            } else {
                pl = pc + 1;
            }
        } while (pl <= pr);

        if (idx != -1 || idx != 0) {
            for (int i = idx - 1; i >= 0; i--) {
                if (a[i] == key) idx = i;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수? : ");
        int num = stdIn.nextInt();

        int[] a = new int[num];
        System.out.println("오름차순의 배열을 입력하시오, KEY값과 같은 가장 앞쪽에 위치하는 배열의 요소의 인덱스를 찾습니다.");
        System.out.print("a[0] : ");
        a[0] = stdIn.nextInt();
        for (int i = 1; i < num; i++) {
            do {
                System.out.print("a[" + i + "] : ");
                a[i] = stdIn.nextInt();
            } while (a[i] < a[i-1]);
        }
        System.out.print("KEY? : ");
        int key = stdIn.nextInt();

        int idx = binSearchX(a, num, key);
        if (idx == -1) System.out.println("찾고자 하는 KEY값이 배열에 없습니다.");
        else System.out.println("찾고자 하는 KEY값의 제일 앞의 INDEX는 a[" + idx + "] 입니다.");

    }

}
