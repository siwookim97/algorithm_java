package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1789 {
    public static int maxN(long N) {
        long sum = 0;
        int i = 1;
        for (; sum <= N; i++) {
            sum += i;
        }
        return i - 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        System.out.println(maxN(N));
    }
}
