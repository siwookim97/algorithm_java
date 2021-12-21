package Chapter01;

import java.util.Scanner;

public class Median {
    static int med3(int a, int b, int c){
        if(a >= b) {
            if (b >= c)
                return b;
            else if (c >= a)
                return a;
            else
                return c;
        }
        else if(a > c)
            return a;
        else if(b > c)
            return c;
        else
            return b;
    }

    public static void main(String[] arg) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("med(3,2,1) : " + med3(3,2,1));
        System.out.println("med(3,2,2) : " + med3(3,2,2));
        System.out.println("med(3,1,2) : " + med3(3,1,2));
        System.out.println("med(3,2,3) : " + med3(3,2,3));
        System.out.println("med(2,1,3) : " + med3(2,1,3));
        System.out.println("med(3,3,2) : " + med3(3,3,2));
        System.out.println("med(3,3,3) : " + med3(3,3,3));
        System.out.println("med(2,2,3) : " + med3(2,2,3));
        System.out.println("med(2,3,1) : " + med3(2,3,1));
        System.out.println("med(2,3,2) : " + med3(2,3,2));
        System.out.println("med(1,3,2) : " + med3(1,3,2));
        System.out.println("med(2,3,3) : " + med3(2,3,3));
        System.out.println("med(1,2,3) : " + med3(1,2,3));

    }
}
