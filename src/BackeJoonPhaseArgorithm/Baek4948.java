package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek4948 {
    public static boolean[] prime = new boolean[246913];

    public static void get_prime() {
        // 0 과 1 은 소수가 아니므로 ture
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        get_prime();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;
            int cnt = 0;
            for (int i = n + 1; i <= n * 2 ; i++) {
                if (prime[i] == false)
                    cnt++;
            }
            sb.append(cnt + "\n");
        }

        System.out.println(sb);
    }
}
