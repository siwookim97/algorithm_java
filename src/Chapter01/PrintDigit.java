package Chapter01;

import java.util.Scanner;

public class PrintDigit {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int n;
        System.out.println("양의 정수의 자리값을 구함");

        do{
            System.out.print("n의 값은? : ");
            n = stdIn.nextInt();
            if(n <= 0)
                System.out.println("양의 정수를 입력하시오.");
        } while(n <= 0);

        int digit = 0;
        while(n > 0 ) {
            n /= 10;
            digit++;
        }

        System.out.println("n의 자릿수는 : " + digit + "입니다.");
    }
}
