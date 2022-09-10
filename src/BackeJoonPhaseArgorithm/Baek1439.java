package BackeJoonPhaseArgorithm;

import java.util.Scanner;

public class Baek1439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int cnt0 = 0;
        int cnt1 = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(i + 1);
            if (ch1 == '0' && ch1 != ch2) {
                cnt0++;
            }
            else if (ch1 == '1' && ch1 != ch2) {
                cnt1++;
            }

            if (i == str.length() - 2) {
                if (ch2 == '0')
                    cnt0++;
                if (ch2 == '1')
                    cnt1++;
            }
        }
        System.out.println(Math.min(cnt0, cnt1));
    }
}
