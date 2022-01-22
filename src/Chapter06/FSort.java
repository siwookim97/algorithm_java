package Chapter06;

import java.util.Scanner;

public class FSort {
    static void fSort(int[] a, int n, int max) {
        int[] f = new int[max + 1];
        int[] b = new int[n];

        for (int i = 0; i < n; i++)
            f[a[i]]++;
        for (int i = 1; i <= max; i++)
            f[i] += f[i - 1];
        for (int i = n - 1; i >= 0; i--)
            b[--f[a[i]]] = a[i];
        for (int i = 0; i < n; i++)
            a[i] = b[i];
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("도수 정렬");
        System.out.print("요솟수 : ");
        int n = stdIn.nextInt();
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            do {
                System.out.println("x[" + i + "] : ");
                x[i] = stdIn.nextInt();
            } while (x[i] < 0);
        }

        int max = x[0];
        for (int i = 1; i < n; i++) {
            if (max < x[i])
                max = x[i];
        }

        fSort(x, n, max);

        System.out.println("오름차순으로 정렬 완료");
        for (int i = 0; i < n; i++)
            System.out.println("x[" + i + "] : " + x[i]);
    }
}
