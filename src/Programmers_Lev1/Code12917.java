package Programmers_Lev1;

import java.util.Arrays;

public class Code12917 {
    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abababab";

        System.out.println(solution(s));
    }
}
