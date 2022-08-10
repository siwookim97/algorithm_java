package Programmers_Lev1;

import java.util.ArrayList;
import java.util.Arrays;

public class Code1845 {
    public static int solution(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == (nums[i]))
                    break;
                if (j == list.size() - 1) {
                    list.add(nums[i]);
                }
            }
        }

        if (list.size() > nums.length / 2)
            return nums.length / 2;
        else
            return list.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,3,3,2,2}));
    }
}
