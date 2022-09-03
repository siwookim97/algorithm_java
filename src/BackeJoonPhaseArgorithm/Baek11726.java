package BackeJoonPhaseArgorithm;

import java.util.Scanner;

public class Baek11726 {
    public static void main(String[] args) {
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        Scanner sc = new Scanner(System.in);

        for (int i = 4; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[sc.nextInt()]);
    }
}
