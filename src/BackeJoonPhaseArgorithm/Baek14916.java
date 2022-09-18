package BackeJoonPhaseArgorithm;

import java.util.Scanner;

public class Baek14916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt2 = 0;

        for (int i = n; i >= 0;) {
            if (i % 5 == 0) {
                System.out.println(cnt2 + (i / 5));
                break;
            }
            if (i == 1) {
                System.out.println(-1);
                break;
            }
            if (i == 0 && n % 2 == 0) {
                System.out.println(cnt2);
                break;
            }
            i -= 2;
            cnt2++;
        }
    }
}
