package Programmers_Lev2;

import java.util.Arrays;

public class Code12941 {
    public static int solution(int []A, int []B)
    {
        int sum = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            sum += (A[i] * B[B.length - 1 -i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2}, new int[]{3,4}));
    }
}
