package Programmers_Lev1;

import java.util.*;

public class Code407879 {
    public static int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }


        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = solution(new int[]{5,0,2,7});
        for (int i : arr)
            System.out.println(i);
    }
}
