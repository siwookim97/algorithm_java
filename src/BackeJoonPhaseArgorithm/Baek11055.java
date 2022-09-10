package BackeJoonPhaseArgorithm;

import java.util.Scanner;

public class Baek11055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        long max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        long[] dp = new long[N];
        dp[0] = arr[0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        for (long i : dp) {
            System.out.println(i);
        }

        System.out.println(max);
    }
}
