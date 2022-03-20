package BackeJoonPhaseArgorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Baek4153 {
    static int med3(int a, int b, int c) {
        if (a >= b) {
            if (b >= c)
                return b;
            else if (a <= c)
                return a;
            else
                return c;
        } else if (a > c) {
            return a;
        } else if (b > c) {
            return c;
        } else {
            return b;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int a, b, c;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0)
                break;

            int min = Math.min(Math.min(a, b), c);
            int max = Math.max(Math.max(a, b), c);
            int med = med3(a, b, c);

            if (min * min + med * med == max * max)
                bw.write("right\n");
            else
                bw.write("wrong\n");
        }

        bw.flush();
        bw.close();
    }
}
