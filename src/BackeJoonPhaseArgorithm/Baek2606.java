package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek2606 {
    static int[][] map;
    static boolean[] visit;
    static int count = 0;
    static int num;
    static int line;

    public static int dfs(int vi) {
        visit[vi] = true;

        for (int i = 1; i < num+1; i++) {
            if (map[vi][i] == 1 && visit[i] == false) {
                count++;
                dfs(i);
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        visit = new boolean[num + 1];
        map = new int[num + 1][num + 1];

        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = 1;
        }

        System.out.println(dfs(1));
    }
}
