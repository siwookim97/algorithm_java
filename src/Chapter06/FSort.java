package Chapter06;

import java.util.Scanner;

public class FSort {
    static void fSort(int[] a, int n, int min, int max) {
        int[] f = new int[max - min  + 2];
        int[] b = new int[n];

        for (int i = 0; i < n; i++)
            f[a[i] - min]++;

        for (int i = 1; i <= max -min + 1; i++)
            f[i] += f[i - 1];

        for (int i = n - 1; i >= 0; i--) // 목적 배열인 b 를 n - 1부터 넣지 않으면 순서가 바뀌는 부로안전 배열이 되기도 한다
            b[--f[a[i] - min]] = a[i];

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
                System.out.print("x[" + i + "] : ");
                x[i] = stdIn.nextInt();
        }

        int min = x[0];
        for (int i = 1; i < n; i++) {
            if (min > x[i])
                min = x[i];
        }

        int max = x[0];
        for (int i = 1; i < n; i++) {
            if (max < x[i])
                max = x[i];
        }

        fSort(x, n, min, max);

        System.out.println("오름차순으로 정렬 완료");
        for (int i = 0; i < n; i++)
            System.out.println("x[" + i + "] : " + x[i]);
    }
}
