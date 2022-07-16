package Programmers_Lev1;

import java.util.Stack;

public class Code64061 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int temp = board[j][moves[i] - 1];
                if (temp == 0) {
                    continue;
                }
                else {
                    if (bucket.empty() || bucket.peek() != temp) {
                        bucket.push(temp);
                        board[j][moves[i] - 1] = 0;
                        break;
                    }
                    else {
                        bucket.pop();
                        board[j][moves[i] - 1] = 0;
                        answer += 2;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
         int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
         int[] moves = {1,5,3,5,1,2,1,4};

         System.out.println(solution(board, moves));
    }
}
