package Programmers_Lev1;

import java.io.IOException;
import java.util.Arrays;

public class Code42748 {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int a, b, c;
        for (int i = 0; i < commands.length; i++) {
            a = commands[i][0];
            b = commands[i][1];
            c = commands[i][2];
            int[] arr = new int[b - a + 1];
            for (int j = a - 1; j < b; j++) {
                arr[j - a + 1] = array[j];
            }
            Arrays.sort(arr);
            answer[i] = arr[c - 1];
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = solution(array, commands);
        for (int i = 0; i < answer.length; i++) {
           System.out.println(answer[i]);
        }
    }
}
