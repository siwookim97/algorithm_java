package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Word1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char result = '\0';
        int maxIdx = 26;
        int max = -1;
        int[] arr = new int[27];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }

        String str = br.readLine();
        String upperStr = str.toUpperCase();

        for (int i = 0; i < upperStr.length(); i++) {
            arr[(int) upperStr.charAt(i) - 65]++;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > max) {
                maxIdx = i;
                max = arr[i];
            } else if (arr[i] < max) {

            } else {
                maxIdx = 26;

            }
        }
        if (maxIdx == 26)
            result = '?';
        else
            result = (char) (maxIdx + 65);

        System.out.println(result);
    }
}
