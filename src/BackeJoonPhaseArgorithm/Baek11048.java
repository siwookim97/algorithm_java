package BackeJoonPhaseArgorithm;

import java.util.Scanner;

public class Baek11048 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];
        int[][] dp = new int[N][M];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = arr[0][0];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0)
                    continue;

                if (i == 0 && j > 0) {
                    dp[i][j] = dp[i][j - 1] + arr[i][j];
                }
                else if (j == 0 && i > 0) {
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                }
                else {
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + arr[i][j];
                }
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}