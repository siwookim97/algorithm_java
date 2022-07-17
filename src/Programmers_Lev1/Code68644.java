package Programmers_Lev1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Code68644 {
    public static int[] solution(int[] numbers) {
        TreeSet<Integer> list = new TreeSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                    list.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[list.size()];
        int cnt = 0;
        for (Integer i : list) {
            answer[cnt] = i;
            cnt++;
        }

        return answer;
    }

        public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        int[] result = solution(numbers);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
