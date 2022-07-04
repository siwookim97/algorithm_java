package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = arr.length - 2; i >= 0 ; i--) {
            if (arr[i] >= arr[i + 1]) {
                cnt = cnt + arr[i] - arr[i + 1] + 1;
                arr[i] = arr[i + 1] - 1;
            }
        }

        System.out.println(cnt);
    }
}
