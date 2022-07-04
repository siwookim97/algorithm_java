package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt;


        if (N == 1) {
            cnt = 1;
        }
        else if (N == 2) {
            cnt = Math.min((M + 1) / 2, 4);
        }
        else { // N이 3이상
            if (M < 7) {
                cnt = Math.min(M, 4);
            }
            else {
                cnt = M - 2;
            }
        }
        System.out.println(cnt);
    }
}
