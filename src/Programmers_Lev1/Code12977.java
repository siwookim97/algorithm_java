package Programmers_Lev1;

public class Code12977 {
    public static int solution(int[] nums) {
        int answer = 0;
        boolean tf = false;

        for (int a = 0; a < nums.length - 2; a++) {
            for (int b  = a + 1; b < nums.length - 1; b++) {
                for (int c = b + 1;  c < nums.length; c++) {
                    for (int i = 2; i * i <= nums[a] + nums[b] + nums[c]; i++) {
                        if ((nums[a] + nums[b] + nums[c]) % i == 0) {
                            tf = true;
                            break;
                        }
                    }
                    if (!tf) {
                        answer++;
                        tf = false;
                    }
                    else {
                        tf = false;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4}));
    }
}
