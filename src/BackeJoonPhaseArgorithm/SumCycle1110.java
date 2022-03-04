package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumCycle1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int num = n;
        int cnt = 0;

        while (true) {
            num = ((num % 10) * 10) + (((num / 10) + (num % 10)) % 10);
            cnt++;
            if (num == n)
                break;
        }
        System.out.print(cnt);
    }
}
