package BackeJoonPhaseArgorithm;

import java.io.*;

public class President2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[15][14];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int sum = 0;

                if (i == 0)
                    arr[i][j] = j + 1;
                else {
                    for (int h = 0; h <= j; h++)
                        sum += arr[i - 1][h];
                    arr[i][j] = sum;
                }
            }
        }

        for (int i = 0; i < num; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            bw.write((arr[k][n - 1]) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
