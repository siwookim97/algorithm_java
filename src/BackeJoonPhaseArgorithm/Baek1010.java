package BackeJoonPhaseArgorithm;

import java.util.Scanner;

public class Baek1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] dp = new int[M + 1][N + 1];
            for (int j = 1; j < M + 1; j++) {
                for (int h = 1; h < N + 1; h++) {
                    if (h == 1) {
                        dp[j][h] = j;
                    }
                    else {
                        dp[j][h] = dp[j - 1][h - 1] + dp[j - 1][h];
                    }
                }
            }

            result[i] = dp[M][N];
        }


        for (int i : result) {
            System.out.println(i);
        }
    }
}
