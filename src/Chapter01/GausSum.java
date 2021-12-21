package Chapter01;

import java.util.Scanner;

public class GausSum {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.print("n은 몇인가요? :");
        int n = stdIn.nextInt();
        int sum = (n%2 == 1 ? ((n+1) * (n/2)) + (n+1)/2 : (n+1) * (n/2) );

        System.out.println("가우스 덧셈의 합은 : " + sum + "입니다.");
    }
}
