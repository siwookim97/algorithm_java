package BackeJoonPhaseArgorithm;

import java.util.Scanner;

public class Baek11724 {
    static int[][] map;
    static boolean[] visited;
    static int n;
    static int m;
    static int cnt = 0;

    public static void dfs(int a) {
        if (visited[a] == true)
            return;
        else {
            visited[a] = true;
            for (int i = 0; i < n; i++) {
                if (map[a][i] == 1)
                    dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a - 1][b - 1] = 1;
            map[b - 1][a - 1] = 1;
        }

        for (int i = 0; i < n; i++) {
                if (visited[i] == false) {
                    cnt++;
                    dfs(i);
                }
            }

        System.out.println(cnt);
    }
}
