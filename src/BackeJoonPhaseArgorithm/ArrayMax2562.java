package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayMax2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = -1000;
        int cnt = 0;
        for (int i = 0 ; i < 9; i++) {
            int a;
            if (max < (a = Integer.parseInt(br.readLine()))) {
                max = a;
                cnt = (i + 1);
            }
        }
        System.out.println(max);
        System.out.println(cnt);
    }
}
