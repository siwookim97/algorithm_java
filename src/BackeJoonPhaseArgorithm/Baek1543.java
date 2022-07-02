package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1543 {
    public static int cal(String doc, String str) {
        int cnt = 0;

        for (int i = 0; i < doc.length() - str.length() + 1; i++) {
            if (doc.substring(i, i+str.length()).equals(str)) {
                cnt++;
                i += str.length();
                i--;

            }
            else continue;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String doc = br.readLine();
        String str = br.readLine();

        System.out.println(cal(doc, str));
    }
}
