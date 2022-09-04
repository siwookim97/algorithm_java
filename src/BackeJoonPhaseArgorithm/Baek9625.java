package BackeJoonPhaseArgorithm;

import java.util.Scanner;

public class Baek9625 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int[][] dp = new int[K + 1][2];

        dp[0][0] = 1;
        dp[0][1] = 0;
        for (int i = 1; i < K + 1; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][1] + dp[i - 1][0];
        }

        System.out.println(dp[K][0] + " " + dp[K][1]);
    }
}
