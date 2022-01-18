package Chapter06;

import Chapter04.IntStack;

import java.util.Scanner;

public class QuickSort {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl + pr) / 2];

        System.out.printf("a[%d]~a[%d] : {", left, right);
        for (int i = left; i < right; i++)
            System.out.printf("%d, ", a[i]);
        System.out.printf("%d}\n", a[right]);

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) quickSort(a, left, pr);
        if (pl < right) quickSort(a, pl, right);
    }

    static void quickSort2(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        while (lstack.isEmpty() != true) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int x = a[(right + left) / 2];

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);

            if (pr - left <= right - pl) { // 스택에 쌓이는 데이터의 수를 줄이 기위한 조건문
                if (left < pr) {
                    lstack.push(left);
                    rstack.push(pr);
                }
                if (pl < right) {
                    lstack.push(pl);
                    rstack.push(right);
                }
            } else {
                if (pl < right) {
                    lstack.push(pl);
                    rstack.push(right);
                }
                if (pr > left) {
                    lstack.push(left);
                    rstack.push(pr);
                }
            }
        }
    }

    static void quickSort3(int[] a, int left, int right) {

        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        while (lstack.isEmpty() != true) {
            if (right - left < 9) {
                for (int i = left + 1; i <= right; i++) {
                    int tmp = a[i];
                    int j;
                    for (j = i; j > left && a[j - 1] > tmp; j--)
                        a[j] = a[j - 1];
                    a[j] = tmp;
                }
            } else {
                int pl = left = lstack.pop();
                int pr = right = rstack.pop();
                int x = a[(right + left) / 2];

                do {
                    while (a[pl] < x) pl++;
                    while (a[pr] > x) pr--;
                    if (pl <= pr)
                        swap(a, pl++, pr--);
                } while (pl <= pr);

                if (pr - left <= right - pl) { // 스택에 쌓이는 데이터의 수를 줄이 기위한 조건문
                    if (left < pr) {
                        lstack.push(left);
                        rstack.push(pr);
                    }
                    if (pl < right) {
                        lstack.push(pl);
                        rstack.push(right);
                    }
                } else {
                    if (pl < right) {
                        lstack.push(pl);
                        rstack.push(right);
                    }
                    if (pr > left) {
                        lstack.push(left);
                        rstack.push(pr);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] a = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("a[" + i + "] : ");
            a[i] = stdIn.nextInt();
        }

        quickSort3(a, 0, nx - 1);

        System.out.println("오름차순으로 정렬 완료");
        for (int i = 0; i < nx; i++)
            System.out.println("a[" + i + "] : " + a[i]);
    }
}
