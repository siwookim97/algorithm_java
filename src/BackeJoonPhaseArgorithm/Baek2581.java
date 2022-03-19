package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2581 {
    public static int decimal(int m, int n, int[] arr) {
        int h = 0;
        for (int i = m; i < n + 1; i++) {
            int j = 2;

            if (i == 1)
                continue;
            else if (i == 2) {
                arr[h] = i;
                h++;
                continue;
            } else if (i == 3) {
                arr[h] = i;
                h++;
                continue;
            } else {
                for (; j < i - 1; j++) {
                    if (i % j == 0) {
                        break;
                    }
                }
            }
            if (j == i - 1) {
                arr[h] = i;
                h++;
            }
        }

        if (arr[0] == 0)
            return -1;
        else
            return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N - M + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        int result = decimal(M, N, arr);

        if (result == -1) {
            System.out.println(-1);
        } else {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0)
                    break;
                sum += arr[i];
            }
            System.out.println(sum);
            System.out.println(arr[0]);
        }
    }
}
