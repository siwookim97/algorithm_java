package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alphabet10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        String str = br.readLine();

        for (int i = 0; i < str.length() ; i++) {
            int chAscii = (int)str.charAt(i) - 97;
            if (arr[chAscii] == -1)
                arr[chAscii] = i;
        }

        for (int result : arr) {
            System.out.print(result + " ");
        }
    }
}
