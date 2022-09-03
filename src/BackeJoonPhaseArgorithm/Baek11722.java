package BackeJoonPhaseArgorithm;

import java.util.Scanner;

public class Baek11722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        int max = 0;

        for (int i = 1; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < N + 1; i ++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i] < arr[j] && dp[i] < dp[j] + 1) {
                    dp[i]++;
                }
            }
            if (dp[i] > max)
                max = dp[i];
        }


        System.out.println(max);

    }
}
