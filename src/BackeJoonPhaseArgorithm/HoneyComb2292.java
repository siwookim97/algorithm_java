package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HoneyComb2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 1;
        int sum = 1;

        if (n == 1)
            System.out.println(cnt);
        else {
            int i = 1;
            while(sum < n) {
                sum = sum + (i * 6);
                cnt++;
                i++;
            }
            System.out.println(cnt);
        }
    }
}
