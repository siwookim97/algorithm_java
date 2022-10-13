package BackeJoonPhaseArgorithm;

import java.util.Scanner;

public class Baek1012 {
    static int[][] map;
    static int m, n, k, t;
    static int cnt;
    static int[] result;
    static boolean[][] visited;
    static int[] addX = {0, 0, -1, 1};
    static int[] addY = {-1, 1, 0, 0};

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int curX = x + addX[i];
            int curY = y + addY[i];

            if (curX >= 0 && curY >= 0 && curX < m && curY < n && map[curY][curX] == 1 && !visited[curY][curX]) {
                dfs(curY, curX);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();
        result = new int[t];

        for (int i = 0; i < t; i++) {
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();
            cnt = 0;
            map = new int[n][m];
            visited = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = 1;
            }

            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (!visited[a][b] && map[a][b] == 1) {
                        cnt++;
                        dfs(a, b);
                    }
                }
            }
            result[i] = cnt;
        }

        for (int i : result) {
            System.out.println(i);
        }
    }
}
