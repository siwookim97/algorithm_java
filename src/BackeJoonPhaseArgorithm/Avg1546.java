package BackeJoonPhaseArgorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Avg1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = Integer.parseInt(br.readLine());
        int num;
        int max = 0;
        float avg = 0;
        int[] arr = new int[cnt];
        float[] arrD = new float[cnt];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < cnt; i++) {
            num = Integer.parseInt(st.nextToken());
            if (num > max)
                max = num;
            arr[i] = num;
        }
        for (int i = 0; i < cnt; i++) {
            arrD[i] = ((float)arr[i] / max) * 100;
            avg += arrD[i];
        }
        System.out.println(avg / cnt);
    }
}
