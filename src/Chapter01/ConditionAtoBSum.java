package Chapter01;

import java.util.Scanner;

public class ConditionAtoBSum {
    static int sum(int a, int b) {
        int sum = 0;

        for(; a <= b ; a++) {
            sum += a;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int sum = 0;

        System.out.print("A : ");
        int a = stdIn.nextInt();
        int b;
        do {
            System.out.print("B : ");
            b = stdIn.nextInt();
            if(a >= b) System.out.println("A보다 큰 B의 값을 입력하세요.");
        } while(a >= b);

        System.out.println("A to b : " + sum(a,b));
    }
}
