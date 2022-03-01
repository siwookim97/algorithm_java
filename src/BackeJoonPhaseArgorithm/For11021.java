package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class For11021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 1; i <= cnt; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            bw.write("Case #" + i + ": "
                    + (Integer.parseInt(st.nextToken())
                    + Integer.parseInt(st.nextToken())) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
