package BackeJoonPhaseArgorithm;

import java.util.Scanner;

public class Baek9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] result = new long[n];

        for (int i = 0; i < n; i++) {
            int cnt = sc.nextInt();
            long[] dp = new long[cnt + 8];
            dp[0] = dp[1] = dp[2] = 1;
            dp[3] = dp[4] = 2;
            dp[5] = 3;
            dp[6] = 4;
            dp[7] = 5;
            for (int j = 8; j < dp.length; j++) {
                dp[j] = dp[j - 1] + dp[j - 5];
            }
            result[i] = dp[cnt - 1];
        }

        for (long i : result) {
            System.out.println(i);
        }
    }
}
