package Chapter5;

import java.util.Scanner;

public class GCDArray {
    static int gcd(int x, int y) {
        int temp;
        while (y != 0) {
            temp = y;
            y = x % y;
            x = y;
        }
        return x;
    }

    static int gcdArray(int[] a) {
        return 1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] a = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print((i + 1) + "번째 : ");
            a[i] = stdIn.nextInt();
        }

        System.out.println("최대 공약수의 결과는 " + gcdArray(a) + "입니다.");
    }
}
