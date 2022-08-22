package Programmers_Lev2;

public class Code77485 {
    static int[][] board = {};

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        board = new int[rows][columns];

        // 배열 할당
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = (columns * i) + 1 + j;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int min = 10001;
            int aY = queries[i][0] - 1;
            int aX = queries[i][1] - 1;
            int bY = queries[i][2] - 1;
            int bX = queries[i][3] - 1;
            int x = aX;
            int y = aY;
            int temp = board[y + 1][x];
            for (int j = 0; j < (bX -aX + bY - aY) * 2; j++) {
                int temp2;
                if (board[y][x] < min) {
                    min = board[y][x];
                }

                if (y == aY && x < bX) {
                    temp2 = board[y][x];
                    board[y][x] = temp;
                    temp = temp2;
                    x++;
                }
                else if (x == bX && y < bY) {
                    temp2 = board[y][x];
                    board[y][x] = temp;
                    temp = temp2;
                    y++;
                }
                else if (y == bY && x > aX) {
                    temp2 = board[y][x];
                    board[y][x] = temp;
                    temp = temp2;
                    x--;
                }
                else {
                    temp2 = board[y][x];
                    board[y][x] = temp;
                    temp = temp2;
                    y--;
                }
            }

            answer[i] = min;
          //  System.out.println("min : " + min);
          //  System.out.println();

        }


        return answer;
    }

    public static void main(String[] args) {
        int[] arr = solution(6, 6, new int[][]{{2,2,5,4}, {3,3,6,6}, {5,1,6,3}});

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
