package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Avg4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] arr;
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            int count = 0; // 평균을 넘긴 학생
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); // 학생 수 입력(num)
            arr = new int[num];
            double sum = 0.0;
            for (int j = 0; j < num; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }
            double avg = (sum / num);

            for (int j = 0; j < num; j++) {
                if (arr[j] > avg) {
                    count++;
                }
            }
            sb.append(String.format("%.3f", ((double)count / num) * 100)).append("%").append("\n");
        }
        System.out.println(sb);
    }
}
