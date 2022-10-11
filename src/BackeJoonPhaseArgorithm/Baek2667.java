package BackeJoonPhaseArgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Baek2667 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] nowX = {0, 0, 1, -1};
    static int[] nowY = {1, -1, 0, 0};
    static int[] arr = new int[25 * 25];
    static int count =  0;

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        arr[count]++;

        for (int i = 0; i < 4; i++) {
            int valX = nowX[i] + x;
            int valY = nowY[i] + y;

            if (valX < n && valY < n && valX >= 0 && valY >= 0 && visited[valX][valY] == false && map[valX][valY] == 1) {
                dfs(valX, valY);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false && map[i][j] == 1) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        Arrays.sort(arr);
        System.out.println(count);
        for (int i = 25 * 25 - count; i < 25 * 25; i++) {
            System.out.println(arr[i]);
        }
    }
}