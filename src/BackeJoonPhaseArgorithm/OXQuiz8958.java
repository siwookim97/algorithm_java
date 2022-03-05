package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OXQuiz8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        String[] result = new String[cnt];
        int[] score = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            result[i] = br.readLine();
        }

        for (int i = 0; i < cnt; i++) {
            int[] total = new int[result[i].length()];
            if (result[i].charAt(0) == 'O') {
                total[0] = 1;
                score[i] += total[0];
            }
            for (int j = 1; j < result[i].length(); j++) {
                if (result[i].charAt(j) == 'O') {
                    total[j] = total[j - 1] + 1;
                }
                score[i] += total[j];
            }
        }

        for (int t : score) {
            System.out.println(t);
        }
    }
}
