package BackeJoonPhaseArgorithm;

import java.io.*;

public class Baek11729 {
    public static StringBuilder sb = new StringBuilder();
    public static int cnt = 0;

    private static void hanoi(int num, int start, int mid, int to) {
        if (num == 1) {
            sb.append(start + " " + to + "\n");
            cnt++;
            return;
        }
        hanoi(num - 1, start, to, mid);
        sb.append(start + " " + to + "\n");
        cnt++;
        hanoi(num - 1, mid, start, to);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 2, 3);

        System.out.println(cnt);
        System.out.println(sb);
    }
}