package BackeJoonPhaseArgorithm;

import java.io.*;

public class Star2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());

        for (int i = 1 ; i <= cnt; i++) {
            for (int j = 1; j <= cnt - i; j++) {
                bw.write(" ");
            }
            for (int h = 1; h <= i; h++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
