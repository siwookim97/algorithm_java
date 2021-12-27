package Chapter03;

import java.util.Scanner;

public class SeqSearch {
    static int seqSearch(int[] a, int num, int key) {
        for(int i = 0; i < num; i++) {
            if(a[i] == key) return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수는? : ");
        int num = stdIn.nextInt();
        int[] a = new int[num];

        for(int i = 0; i < num; i++) {
            System.out.print("a[" + i + "] : ");
            a[i] = stdIn.nextInt();
        }

        System.out.print("검색 KEY? : ");
        int key = stdIn.nextInt();

        int idx = seqSearch(a, num, key);
        if(idx == -1) System.out.println("찾는 값이 없습니다.");
        else System.out.println("찾는 값은 a[" + idx + "]에 있습니다.");
    }
}
