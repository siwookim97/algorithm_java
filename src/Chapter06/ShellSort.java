package Chapter06;

import java.util.Scanner;

public class ShellSort {
    static void shellSort(int[] a, int n) {
        int count = 0;
        for (int h = n / 2; h > 0; h /= 2) // 4-정렬 ~ 2-정렬 ~ 1-정렬 순서처럼 정렬
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                    count++;
                }
                a[j + h] = tmp;
                count++;
            }
        System.out.println("요소의 이동 횟수 : " + count);
    }

    static void shellSort2(int[] a, int n) {
        int count = 0;
        int h;
        for (h = 1; h < n / 9; h = h * 3 + 1) ;

        for (; h > 0; h /= 3)
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                    count++;
                }
                a[j + h] = tmp;
                count++;
            }
        System.out.println("요소의 이동 횟수 : " + count);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("셸 정렬(버전 2)");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        shellSort2(x, nx);

        System.out.println("오름차순으로 정렬.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}
