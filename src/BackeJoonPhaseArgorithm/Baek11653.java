package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        int k = 2;
        while (num != 1) {
            if (num % k == 0) {
                sb.append(k + "\n");
                num = num / k;
            }else {
                k++;
            }
        }
        System.out.println(sb);
    }
}
