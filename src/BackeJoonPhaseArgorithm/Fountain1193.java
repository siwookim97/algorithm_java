package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fountain1193 {
    static int layerSum(int layer) {
        int sum = 0;

        for (int i = 1; i < layer; i++)
            sum += i;

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int layer = 1;


        if (n == 1) {
            System.out.println("1/1");
            return;
        } else {
            int i;
            for (i = 1; i < n; ) {  // 층을 구하고
                layer++;
                i += layer;
            }
            int sum = n - layerSum(layer);
            if (layer % 2 == 0) {
                for (int j = 0; j < sum; j++) {
                    sb.setLength(0);
                    sb.append((j + 1) + "/" + (layer - j));
                }
            } else {
                for (int j = 0; j < sum; j++) {
                    sb.setLength(0);
                    sb.append((layer - j) + "/" + (j + 1));
                }
            }
        }
        System.out.println(sb);
    }
}