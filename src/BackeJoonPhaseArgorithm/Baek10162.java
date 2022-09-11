package BackeJoonPhaseArgorithm;

import java.util.Scanner;

public class Baek10162 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        if (T % 10 != 0)
            System.out.println("-1");
        else {
            int a = 0;
            int b = 0;
            int c = 0;
            while (T != 0) {
                if (T >= 300) {
                    a++;
                    T -= 300;
                }
                else if (T >= 60) {
                    b++;
                    T -= 60;
                }
                else {
                    c++;
                    T -= 10;
                }
            }
            System.out.println(a + " " + b + " " + c);
        }
    }
}
