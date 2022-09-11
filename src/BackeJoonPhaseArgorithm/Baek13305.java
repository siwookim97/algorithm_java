package BackeJoonPhaseArgorithm;

import java.util.Scanner;

public class Baek13305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] distance = new long[n - 1];
        long[] spot = new long[n];

        for (int i = 0; i < n - 1; i++) {
            distance[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            spot[i] = sc.nextLong();
        }
        long sum = spot[0] * distance[0];
        long minPrice = spot[0];
        for (int i = 1; i < n - 1; i++) {
            if (minPrice > spot[i]) {
                minPrice = spot[i];
                sum = sum + (minPrice * distance[i]);
            }
            else {
                sum = sum + (minPrice * distance[i]);
            }
        }
        System.out.println(sum);
    }
}