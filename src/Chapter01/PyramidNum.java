package Chapter01;

import java.util.Scanner;

public class PyramidNum {
    static void npira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i - 1; j++) {
                System.out.printf("%d", i % 10);
            }
            System.out.printf("%d", i % 10);
            for (int j = 1; j <= i - 1; j++) {
                System.out.printf("%d", i % 10);
            }
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("몇단계의 피라미드를 만드시겠습니까? : ");
        int n = stdIn.nextInt();

        npira(n);
    }
}
