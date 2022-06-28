package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Baek2217 {
    public static void sort(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int cal(int[] arr) {
        int temp;

//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 1; j < arr.length; j++) {
//                if (arr[i] > arr[j]) {
//                    sort(arr, i, j);
//                }
//            }
//        }
        Arrays.sort(arr);

        temp = arr[0] * arr.length;
        for (int i = 1; i < arr.length; i++) {
            if (temp < arr[i] * (arr.length - i))
                temp = arr[i] * (arr.length - i);
        }

        return temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(cal(arr));
    }

}
