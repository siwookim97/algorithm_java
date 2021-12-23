package Chapter01;

import java.util.Scanner;

public class Figure {
    static void triangleLB(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleLU(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleRU(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 6 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleRB(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }
            for (int j= 1; j<= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("몇단의 이등변 삼각형을 만드시겠습니까?");
        int n = stdIn.nextInt();
        triangleLB(n);
        System.out.println();
        triangleLU(n);
        System.out.println();
        triangleRU(n);
        System.out.println();
        triangleRB(n);
    }
}

