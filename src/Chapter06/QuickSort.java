package Chapter06;

import Chapter04.IntStack;

import java.util.Scanner;

public class QuickSort {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort(int[] a, int left, int right) { // 가장 기본적인 퀵 정렬, 재귀적으로 함수를 호출하여 구현
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

    static void quickSort2(int[] a, int left, int right) { // 스택을 사용한 퀵 정렬, 재귀적 호출이 불필요하다
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

    static void quickSort3(int[] a, int left, int right) { // 스택을 사용하는 퀵 정렬, 스택에 쌓이는 데이터의 양을 최소화하는 알고리즘

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

    static int med3(int a, int b, int c) { // 피벗의 중간값을 결정하는 함수
        if (a >= b) {
            if (b >= c)
                return b;
            else if (a <= c)
                return a;
            else
                return c;
        }
        else if (a > c)
            return a;
        else if (b > c)
            return c;
        else
            return b;
    }

    static int med3_a(int[] s, int a, int b, int c) { // 피벗의 중간값을 결정하는 함수
        if (s[a] >= s[b]) {
            if (s[b] >= s[c]) { // a >= b >= c
                swap(s, b, c);
                return s[b];
            }
            else if (s[a] <= s[c]) { // c >= a >= b
                swap(s, a, c);
                return s[a];
            }
            else { // a >= c >= b
                return s[c];
            }
        }
        else if (s[a] > s[c]) { // b >= a > c
            swap(s, a, c);
            return s[a];
        }
        else if (s[b] > s[c])
            return s[c];
        else
            return s[b];
    }

    static void quickSortPivot1_recur(int[] a, int left, int right) { // med3 메서드를 이용해서 중간값을 피벗으로 설정한 재귀형태의 퀵 정렬
        int pl = left;
        int pr = right;
        int x = med3_a(a, pl, pr, (pl + pr) / 2);

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) quickSortPivot1_recur(a, left, pr);
        if (pl < right) quickSortPivot1_recur(a, pl, right);
    }

    static void quickSortPivot1_nonRecur(int[] a, int left, int right) { // med3 메서드를 이용해서 중간값을 피벗으로 설정한 스택을 사용한 퀵 정렬
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        while (lstack.isEmpty() != true) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int x = med3(a[pl], a[pr], a[(pl + pr) / 2]);

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);

            if (left < pr) {
                lstack.push(left);
                rstack.push(pr);
            }
            if (pl < right) {
                lstack.push(pl);
                rstack.push(right);
            }
        }
    }

    static void quickSortPivot2_recur(int[] a, int left, int right) { // med3 메서드를 이용한 후 피벗의 위치를 조정한 재귀형태의 퀵 정렬
        int pl = left;
        int pr = right;
        int x = med3(a[left], a[right], a[(left + right) / 2]);
        swap(a, pr - 1, med3(a[left], a[right], a[(left + right) / 2]));

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) quickSortPivot2_recur(a, left, pr);
        if (pl < right) quickSortPivot2_recur(a, left, pr);
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

        quickSortPivot1_nonRecur(a, 0, nx - 1);

        System.out.println("오름차순으로 정렬 완료");
        for (int i = 0; i < nx; i++)
            System.out.println("a[" + i + "] : " + a[i]);
    }
}
