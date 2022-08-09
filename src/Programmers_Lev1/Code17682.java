package Programmers_Lev1;

import java.util.Stack;

public class Code17682 {
    public static int solution(String dartResult) {
        int sum = 0;

        int[] arr = {0, 0, 0};
        String str = "";
        int idx = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            if (Character.isDigit(dartResult.charAt(i))) { // 숫자이면
                str = str + dartResult.charAt(i);
            }
            else if (dartResult.charAt(i) == 'S') {
                arr[idx] = (int)Math.pow(Integer.parseInt(str), 1);
                System.out.println(str);
            }
            else if (dartResult.charAt(i) == 'D') {
                arr[idx] = (int)Math.pow(Integer.parseInt(str), 2);
                System.out.println(str);
            }
            else if (dartResult.charAt(i) == 'T') {
                arr[idx] = (int)Math.pow(Integer.parseInt(str), 3);
                System.out.println(str);
            }
            else if (dartResult.charAt(i) == '#') {
                arr[idx] *= (-1);
            }
            else if (dartResult.charAt(i) == '*') {
                arr[idx] *= 2;
                if (idx != 0) {
                    arr[idx - 1] *= 2;
                }
            }

            if (i < dartResult.length() - 1) {
                if (!Character.isDigit(dartResult.charAt(i))) {
                    if (Character.isDigit(dartResult.charAt(i + 1))) {
                        idx++;
                        str = "";
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(i + "   " + arr[i]);
            sum += arr[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
    }
}
