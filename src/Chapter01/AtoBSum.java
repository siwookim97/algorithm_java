package Chapter01;

import java.util.Scanner;

public class AtoBSum {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int sum = 0;

        System.out.print("A : ");
        int a = stdIn.nextInt();
        System.out.print("B : ");
        int b = stdIn.nextInt();

        if(a <= b) {
            while (a <= b) {
                sum += a;
                a++;
            }
        }
        else{
            while (b <= a) {
                sum += b;
                b++;
            }
        }
        System.out.println("A부터 B사이의 합은 : " + sum + "입니다.");
    }
}
