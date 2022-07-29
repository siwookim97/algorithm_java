package Programmers_Lev1;

import java.util.Arrays;

public class Code12933 {
    public static long solution(long n) {
        long answer = 0;
        String str = "" + n;
        int[] arr = new int[str.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(n % 10);
            n = n / 10;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            answer = answer + (long)(arr[i] * Math.pow(10, i));
        }

        return answer;
    }

    public static void main(String[] args) {
        long n = 118372;

        System.out.println(solution(n));
    }
}
