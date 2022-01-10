package Chapter06;

import java.util.Scanner;

public class BubbleSort {
    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - 1; j++)
                if (a[j + 1] < a[j])
                    swap(a, j, j + 1);
    }

    public static void main (String[] args) {
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

        System.out.println("오름차순으로 정렬 완료");
        for (int i = 0; i < n; i++)
            System.out.println("x[" + i + "]=" + x[i]);
    }
}
