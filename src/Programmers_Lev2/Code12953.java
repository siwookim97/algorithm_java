package Programmers_Lev2;

public class Code12953 {
    public static long solution(int[] arr) {
        long answer = 0;
        long mul = 1;
        for (int i = 0; i < arr.length; i++) {
            mul *= arr[i];
        }

        for (int i = 1; i <= mul; i++) {
            int j;
            for (j = 0; j < arr.length; j++) {
                if (i % arr[j] != 0)
                    break;
            }
            if (j == arr.length) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3}));
    }
}
