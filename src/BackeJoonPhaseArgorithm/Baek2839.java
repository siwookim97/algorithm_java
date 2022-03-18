package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int cnt_3 = 0;
        int cnt_5 = 0;

        while (N > 0) {
            if (N >= 5) {  // 5이상
                if (N % 3 == 0) {  // 3으로 나뉨
                    cnt_5 = cnt;
                    cnt_3 = N / 3;

                    cnt++;
                    N -= 5;
                }
                else {  // 3으로 안나뉨
                    cnt++;
                    N -= 5;
                }
            }
            else {  // 5미만
                if (N % 3 == 0) {  // 3으로 나뉨
                    cnt++;
                    N -= 3;
                }
                else {  // 3으로 안나뉨
                    if (cnt_3 != 0 || cnt_5 != 0) {
                        cnt = cnt_3 + cnt_5;
                        break;
                    }
                    else {
                        cnt = -1;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
