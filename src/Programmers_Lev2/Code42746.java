package Programmers_Lev2;

import java.util.Arrays;
import java.util.Comparator;

public class Code42746 {
    public static String solution(int[] numbers) {
        String answer = "";
        int index = numbers.length;
        String[] arr = new String[index];

        for (int i = 0; i < index; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2); // 내림차순
            }
        });

        for (int i = 0; i < index; i++) {
            answer += arr[i];
        }
        if (answer.startsWith("0")) {
            answer = "0";
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{6,10,2}));
    }
}
