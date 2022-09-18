package BackeJoonPhaseArgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Baek2437 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + 1 < arr[i]) {
                break;
            }
            else {
                sum += arr[i];
            }
        }
        System.out.println(sum + 1);
    }
}
