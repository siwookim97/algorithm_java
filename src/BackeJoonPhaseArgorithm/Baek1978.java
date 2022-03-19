package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class Baek1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            int j = 2;

            if (num == 1)
                continue;
            else if (num == 2) {
                cnt++;
                continue;
            } else if (num == 3) {
                cnt++;
                continue;
            } else {
                for (; j < num - 1; j++) {
                    if (num % j == 0) {
                        break;
                    }
                }
            }
            if (j == num - 1)
                cnt++;
        }

        System.out.println(cnt);
    }
}
