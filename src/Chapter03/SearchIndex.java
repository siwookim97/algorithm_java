package Chapter03;

import java.util.Scanner;

public class SearchIndex {
    static int searchIndex(int[] a, int num, int key, int[] idx) {
        int idxNum = 0;

        for (int i = 0; i < num; i++)
            if (a[i] == key) {
                idx[idxNum] = i;
                idxNum++;
            }

        for (int i = 0; idx[i] != 0; i++) {
            System.out.print("  " + idx[i]);
        }
        System.out.println();

        return idxNum;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수를 입력 : ");
        int num = stdIn.nextInt();
        int[] a = new int[num];
        int[] idx = new int[num];

        System.out.println("배열을 입력하세요");

        for (int i = 0; i < num; i++) {
                System.out.print("a[" + i + "] :");
                a[i] = stdIn.nextInt();
        }

        System.out.print("찾고자 하는 값을 입력하시오 : ");
        int key = stdIn.nextInt();
        int idxNum = searchIndex(a, num, key, idx);

        if (idxNum == -1) System.out.println("찾고자 하는 값이 없습니다.");
        else System.out.println("찾고자 하는 값이 " + idxNum + "개 있습니다.");
    }
}
