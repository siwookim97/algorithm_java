package BackeJoonPhaseArgorithm;

import java.io.*;
import java.util.StringTokenizer;

public class StringRepeat2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());  // 입력할 데이터의 수


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();

            for(int j = 0; j < S.length(); j++) {
                char ch = S.charAt(j);
                for (int h = 0; h < R; h++) {
                    bw.write(ch);
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
