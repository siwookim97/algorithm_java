package Chapter03;

import java.util.Scanner;

public class SeqSearchSentinel {

    static int seqSearchSentinel(int[] a, int key, int num) {
        a[num] = key;
        int i;

        for(i = 0; a[i] != key; i++);

        return i == num ? -1 : i;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수를 입력하세요");
        int num = stdIn.nextInt();
        int[] a = new int[num + 1];

        for (int i = 0; i < num; i++) {
            System.out.print("a[" + i + "] : ");
            a[i] = stdIn.nextInt();
        }

        System.out.print("찾고자 하는 KEY :");
        int key = stdIn.nextInt();

        int idx = seqSearchSentinel(a, key, num);
        if (idx == -1) System.out.println("찾고자 하는 값이 없습니다.");
        else System.out.println("찾고자 하는 값이 a[" + idx + "]에 있습니다.");
    }
}
