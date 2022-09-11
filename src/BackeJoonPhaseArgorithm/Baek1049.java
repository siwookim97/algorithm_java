package BackeJoonPhaseArgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Baek1049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] pPrice = new int[m];
        int[] iPrice = new int[m];
        int sum = 0;

        for (int i = 0; i < m; i++) {
            pPrice[i] = sc.nextInt();
            iPrice[i] = sc.nextInt();
        }
        Arrays.sort(pPrice);
        Arrays.sort(iPrice);
        if ((n % 6) * iPrice[0] > pPrice[0]) {
            sum = pPrice[0] * ((n / 6) + 1);
        }
        else {
            sum = pPrice[0] * (n / 6) + (n % 6) * iPrice[0];
        }

        System.out.println(sum);
    }
}