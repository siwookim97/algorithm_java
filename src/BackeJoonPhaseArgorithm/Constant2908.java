package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Constant2908 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String str1 = st.nextToken();
        String str2 = st.nextToken();

        int[] arr1 = new int[3];
        int[] arr2 = new int[3];

        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < 3; i++) {
            arr1[2 - i] = (int)str1.charAt(i) - 48;
            num1 += arr1[2 - i] * (Math.pow(10, i));

            arr2[2 - i] = (int)str2.charAt(i) - 48;
            num2 += arr2[2 - i] * (Math.pow(10, i));
        }

        System.out.println(num1 > num2 ? num1 : num2);
    }
}
