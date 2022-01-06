package Chapter05;

import java.util.Scanner;

public class Factorial {
    static int factorial(int x) {
        int fac = 1;
        for(int i = 1; i <= x; i++) {
            fac *= i;
        }
        return fac;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("x ? :");
        int x = stdIn.nextInt();

        System.out.println("팩토리얼의 결과값은 " + factorial(x) + "입니다.");
    }
}
