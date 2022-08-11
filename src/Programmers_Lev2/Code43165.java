package Programmers_Lev2;

import java.util.ArrayList;

public class Code43165 {
    public static int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }
    public static int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println(solution(new int[]{1,1,1,1,1}, 3));
    }
}
