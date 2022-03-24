package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek9020 {
    static boolean prime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder sbResult = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            for (int j = num / 2; j < num; j++) {
                boolean prime1 = prime(j);
                boolean prime2 = prime(num - j);
                if (prime1 == true && prime2 == true) {
                    sb.append(num - j + " ").append(j + "\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
