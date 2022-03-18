package BackeJoonPhaseArgorithm;

import java.io.*;
import java.util.StringTokenizer;

public class ACMHotel10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int WW;

            if (N % H == 0)  // 층수
                bw.write(String.valueOf(H));
            else
                bw.write(String.valueOf(N % H));

            WW = N / H;
            if (N % H != 0)  // 호수
                WW++;
            if (WW / 10 < 1)
                bw.write("0" + WW + "\n");
            else
                bw.write(WW + "\n");
        }

        bw.flush();
        bw.close();
    }
}
