package Chapter02;

import java.util.Scanner;

public class ReverseArray {
    static void swap(int a[], int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void reverse(int a[]) {
        for (int i = 0; i < a.length / 2; i++) {
            System.out.println("a[" + i + "]과(와) a[" + (a.length - i - 1) + "]을(를) 교환합니다.");
            swap(a, i, a.length - i - 1);

            for (int j = 0; j < a.length; j++)
                System.out.print(a[j] + " ");
            System.out.println();
        }
        System.out.println("역순 정렬을 마쳤습니다.");
    }

    public static void main(String[] args) {
        int[] a = {5, 10, 73, 2, -5, 42, 10, 11, 12, 13};

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        reverse(a);
    }
}
