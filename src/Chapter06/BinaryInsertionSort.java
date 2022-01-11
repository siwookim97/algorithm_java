package Chapter06;

import java.util.Scanner;

public class BinaryInsertionSort {
    static void binaryInsertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int pl = 0; // 처음 인덱스
            int pr = n - 1; // 마지막 인덱스
            int pd; // 삽입하는 위치의 인덱스
            int pc;
            int key = a[i];
            do {
                pc = (pl + pr) / 2; // 중앙 요소의 인덱스
                if (a[pc] == key)
                    break;
                else if (a[pc] < key)
                    pl = pc + 1;
                else
                    pr = pc - 1;
            } while (pl <= pr);
            if (pl <= pr)
                pd = pc + 1;
            else
                pd = pr + 1;

            for (int j = i; j > pd; j--)
                a[j] = a[j - 1];
            a[pd] = key;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i +"] : ");
            x[i] = stdIn.nextInt();
        }

        binaryInsertionSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]=" + x[i]);
    }
}
