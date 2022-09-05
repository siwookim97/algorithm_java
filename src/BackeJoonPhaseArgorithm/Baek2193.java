package BackeJoonPhaseArgorithm;

import java.util.Scanner;

public class Baek2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] dp = new long[N + 1];

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int cnt = i - 2;
            while (cnt > 0) {
                dp[i] += dp[cnt];
                cnt--;
            }
            dp[i]++;
        }

        System.out.println(dp[N]);
    }
}