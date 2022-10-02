package BackeJoonPhaseArgorithm;

import java.util.Scanner;

public class Baek4963 {
    static int w = 10, h = 10, nowX, nowY;
    static int[][] board;
    static boolean[][] visited;
    static int dirX[] = {0, 0, -1 ,1, -1, 1, -1, 1};
    static int dirY[] = {-1, 1, 0, 0, 1, 1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if (w == 0 && h == 0) {
                break;
            }
            board = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (visited[i][j] == false && board[i][j] == 1) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
//            for (int i = 0; i < h; i++) {
//                for (int j = 0; j < w; j++) {
//                    System.out.print(visited[i][j] + " ");
//                }
//                System.out.println();
//            }
            sb.append(cnt);
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int a, int b) {
        visited[a][b] = true;

        for (int i = 0; i < 8; i++) {
            nowX = a + dirX[i];
            nowY = b + dirY[i];

            if (nowX >= 0 && nowX < h && nowY >= 0 && nowY < w && visited[nowX][nowY] == false && board[nowX][nowY] == 1) {
                dfs(nowX, nowY);
            }
        }
    }
}
