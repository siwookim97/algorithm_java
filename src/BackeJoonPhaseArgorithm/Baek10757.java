package BackeJoonPhaseArgorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Baek10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String str1 = st.nextToken();
        String str2 = st.nextToken();
        int[] arr1 = new int[str1.length()];
        int[] arr2 = new int[str2.length()];

        for (int i = 0; i < str1.length(); i++) {
            arr1[str1.length() - 1 - i] = str1.charAt(i) - 48;
        }
        for (int i = 0; i < str2.length(); i++) {
            arr2[str2.length() - 1 - i] = str2.charAt(i) - 48;
        }

        int j;
        int round = 0;
        for (j = 0; j < (str1.length() > str2.length() ? str2.length() : str1.length()); j++) {
            int sum = arr1[j] + arr2[j] + round;

            if (sum / 10 > 0) {
                sb.append((sum - 10));
                round = 1;
            }
            else {
                sb.append(sum);
                round = 0;
            }

            if (str1.length() == str2.length() && round == 1 && str1.length() == j + 1)
                sb.append(1);
        }

        for (; j < (str1.length() < str2.length() ? str2.length() : str1.length()); j++) {
            if (str2.length() > str1.length()) {
                sb.append(arr2[j] + round);
                round = 0;
            } else {
                sb.append(arr1[j] + round);
                round = 0;
            }
        }

        System.out.println(sb.reverse());
    }

}
