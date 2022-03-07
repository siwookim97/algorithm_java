package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArithmeticSequence1065 {
    static int arithmetic_sequence(int n) {
        int[] arr = new int[1000];
        arr[0] = 1;
        for (int i = 1; i < arr.length - 1; i++) {
            int num = i + 1;
            if (num < 100) {
                arr[i] = 1;
            }
            else {
                int hun = num / 100;
                int ten = (num / 10) % 10;
                int one = num % 10;

                if ((hun - ten) == (ten - one)) {
                    arr[i] = 1;
                }
            }
            arr[i] += arr[i - 1];
        }
        arr[999] = arr[998];

        return arr[n - 1];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        System.out.println(arithmetic_sequence(num));
    }
}
