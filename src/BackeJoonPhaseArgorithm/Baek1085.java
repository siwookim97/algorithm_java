package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int result = 0;

        if (h - y > y) {
            result = y > w - x ? (w - x > x ? x : w - x ) : (y > x ? x : y);
        } else {
            result = h - y > w - x ? (w - x > x ? x : w - x ) : (h - y > x ? x : h - y);
        }

        System.out.println(result);
    }
}
