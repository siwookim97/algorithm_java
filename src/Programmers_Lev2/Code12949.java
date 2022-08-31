package Programmers_Lev2;

public class Code12949 {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int h = 0; h < arr2[0].length; h++) {
                int sum = 0;
                for (int j = 0; j < arr1[0].length; j++) {
                    sum = sum + (arr1[i][j] * arr2[j][h]);
                }
               // System.out.println(sum);
                answer[i][h] = sum;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr = solution(new int[][]{{1,2,3,4}, {1,2,3,4}}, new int[][]{{1,2}, {1,2}, {1,2}, {1,2}});

        for (int[] i : arr) {
            for (int j : i) {
                System.out.println(j);
            }
            System.out.println();
        }
    }
}
