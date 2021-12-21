package Chapter01;

import java.util.Scanner;

public class ForLoop {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 몇까지 더하시겟습니까?");
        System.out.print("n : ");

        int n = stdIn.nextInt();
        int sum = 0;
        for(int i = 0 ; i <= n ; i++) {
            sum += i;
        }

        System.out.println("1+2...+n = " + sum);
    }
}
