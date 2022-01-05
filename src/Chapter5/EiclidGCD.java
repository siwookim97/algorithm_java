package Chapter5;

import java.util.Scanner;

public class EiclidGCD {
    static int gcd(int x, int y) {
        while (true) {
            if (x == y)
                return x;

            if (x > y)
                x %= y;
            else if (x < y)
                y %= x;

            if (y == 0)
                return x;
            else if (x == 0)
                return y;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("두 정수의 최대공약수를 구합니다.");

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();
        System.out.print("정수를 입력하세요 : ");
        int y = stdIn.nextInt();

        System.out.println("결과는 " + gcd(x, y) + "입니다.");
    }
}
