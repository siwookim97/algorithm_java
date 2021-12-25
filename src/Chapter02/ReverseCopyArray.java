package Chapter02;

import java.util.Scanner;

public class ReverseCopyArray {
    static void rcopy(int[] a, int[] b) {
        for(int i = 0; i < a.length; i++) {
            b[a.length -i -1] = a[i];
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("배열의 길이를 입력하세요 : ");
        int num = stdIn.nextInt();

        int[] a = new int[num];
        int[] b = new int[num];

        for (int i = 0; i < a.length; i++) {
            System.out.print("a[" + i + "] : ");
            a[i] = stdIn.nextInt();
        }

        rcopy(a, b);
        System.out.print("배열a : ");
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.print("배열b : ");
        for(int i = 0; i < a.length; i++){
            System.out.print(b[i] + " ");
        }
    }
}
