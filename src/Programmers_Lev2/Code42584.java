package Programmers_Lev2;

import java.util.Stack;

public class Code42584 {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            if (i == prices.length - 1) {
                answer[i] = 0;
                break;
            }
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j] || j == prices.length - 1) {
                    answer[i] = j - i;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = solution(new int[]{1,2,3,2,3});
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
