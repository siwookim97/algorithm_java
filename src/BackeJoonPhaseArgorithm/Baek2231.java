package BackeJoonPhaseArgorithm;

import java.util.Scanner;

public class Baek2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int sum = i;
            int tmp = i;
            while (tmp > 0) {
                sum += (tmp % 10);
                tmp /= 10;
            }
            if (sum == n) {
                System.out.println(i);
                break;
            }

            if (i == n - 1)
                System.out.println(0);
        }
    }
}
