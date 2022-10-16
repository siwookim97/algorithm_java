package BackeJoonPhaseArgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Baek2583 {
    static int m, n, k;
    static int[][] map;
    static boolean[][] visited;
    static int cnt = -1;
    static int[] arr = new int[100 * 100];
    static int[] moveX = {0, 0, -1 , 1};
    static int[] moveY = {-1, 1, 0, 0};

    public static void dfs(int y, int x) {
        visited[y][x] = true;
        arr[cnt]++;

        for (int i = 0; i < 4; i++) {
            int curY = y + moveY[i];
            int curX = x + moveX[i];
            if (curY >= 0 && curX >= 0 && curY < m && curX < n && !visited[curY][curX] && map[curY][curX] == 0) {
                dfs(curY, curX);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();
        map = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            int lx = sc.nextInt();
            int ly = sc.nextInt();
            int rx = sc.nextInt();
            int ry = sc.nextInt();

            for (int x = lx; x < rx; x++) {
                for (int y = ly; y < ry; y++) {
                    if (map[y][x] == 0)
                        map[y][x] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(cnt + 1);
        Arrays.sort(arr);
        for (int i = arr.length - cnt - 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
