package BackeJoonPhaseArgorithm;

import java.util.Scanner;

public class Baek14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if (i + arr[i][0] <= N) {
                dp[i + arr[i][0]] = Math.max(dp[i +arr[i][0]], dp[i] + arr[i][1]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[N]);
    }
}
