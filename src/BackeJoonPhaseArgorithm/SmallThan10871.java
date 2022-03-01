package BackeJoonPhaseArgorithm;

import java.io.*;
import java.util.StringTokenizer;

public class SmallThan10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int cnt = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");;

        for (int i = 0; i < cnt; i++) {
            int value = Integer.parseInt(st.nextToken());

            if (value < x)
                sb.append(value).append(' ');
        }
        System.out.println(sb);
        br.close();
    }
}
