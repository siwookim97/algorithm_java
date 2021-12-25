package Chapter02;

import java.util.Random;
import java.util.Scanner;

public class ArraySum {
    static int sumOf(int[] a) {
        int sum = 0;

        for(int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("요솟수를 입력하세요 : ");
        int num = stdIn.nextInt();
        int[] a = new  int[num];

        for(int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(10);
            System.out.print(a[i] + " ");
        }

        System.out.println("배열 a[]의 총합은 " + sumOf(a) + "입니다.");
    }
}
