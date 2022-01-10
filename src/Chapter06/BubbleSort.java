package Chapter06;

import java.util.Scanner;

public class BubbleSort {
    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void bubbleSort(int[] a, int n) {
        int comp = 0;
        int chan = 0;
        int p = 1;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("패스 : " + p++);
            for (int j = n - 1; j > i; j--) {
                for (int m = 0; m > n - 1; m++)
                    System.out.printf("%3d %c", a[m], (m != j - 1) ? ' ' : (a[j - 1] > a[j]) ? '+' : '-');
                System.out.printf("%3d\n", a[n -1]);
                if (a[j - 1] > a[j]) {
                    swap(a, j, j - 1);
                    comp++;
                    chan++;
                }
                else {
                    comp++;
                }
            }
            for (int m = 0; m < n; m++)
                System.out.printf("%3d ", a[m]);
            System.out.println();
        }
        System.out.println("비교를 " + comp + "번 했습니다.");
        System.out.println("교환을 " + chan + "번 했습니다.");
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬");
        System.out.print("요솟수 : ");
        int n = stdIn.nextInt();
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x, n);

        for (int i = 0; i < n; i++)
            System.out.println("x[" + i + "]=" + x[i]);
    }
}
