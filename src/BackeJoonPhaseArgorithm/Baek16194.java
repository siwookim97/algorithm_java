package BackeJoonPhaseArgorithm;

import java.util.Scanner;

public class Baek16194 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] p = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i < p.length; i++) {
            p[i] = sc.nextInt();
            dp[i] = 10001;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + p[j]);
            }
        }

        System.out.println(dp[n]);
    }
}
