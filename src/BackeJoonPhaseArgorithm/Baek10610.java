package BackeJoonPhaseArgorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Baek10610 {
    public static void cal(String N) {
        Integer[] arr = new Integer[N.length()];
        int sum = 0;

        for (int i = 0; i < N.length(); i++) {
            arr[i] = Integer.parseInt(N.substring(i, i+1));
            sum += arr[i];
        }
        Arrays.sort(arr, Collections.reverseOrder());

        if (sum % 3 != 0 || !arr[arr.length - 1].equals(0))
            System.out.println("-1");
        else {
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();

        cal(N);
    }
}
