package Chapter05;

import Chapter04.IntStack;

import java.util.Scanner;

public class Recur3 {
    static void recur3(int n) {
        IntStack s1 = new IntStack(n);
        IntStack s2 = new IntStack(n);
        int n1 = n;
        int n2 = n;

        while (true) {
            if (n1 > 0) {
                s1.push(n1 - 1);
                n1 = n1- 1;
                continue;
            }
            if (n2 < 0) {
                s2.push(n2 - 1);
                n2 = n2 - 1;
                continue;
            }
            if(s1.isEmpty() != true) {
                n1 = s1.pop();
                n2 = s2.pop();
                System.out.println(n)
                continue;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("Recur3");
        System.out.print("n : ");
        int n = stdIn.nextInt();

        recur3(n);
    }
}
