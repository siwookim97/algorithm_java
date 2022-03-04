package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaxMin10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int index = 0;
        int[] arr = new int[idx];
        while(st.hasMoreTokens()) {
            arr[index] = Integer.parseInt(st.nextToken());
            index++;
        }
        Arrays.sort(arr);
        System.out.print(arr[0] + " " + arr[idx - 1]);
    }
}
