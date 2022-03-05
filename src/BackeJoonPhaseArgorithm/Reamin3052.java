package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reamin3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] arr = new boolean[42];
        for (int i = 0; i < 10; i++) {
            int a = (Integer.parseInt(br.readLine()) % 42);
            if (arr[a] == false) {
                arr[a] = true;
            }
        }
        int cnt = 0;
        for (boolean result : arr) {
            if (result) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
