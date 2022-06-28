package Programmers_Lev1;

public class lotto {
    public static  int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int cnt = 0;
        int cnt_0 = 0;
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == 0) {
                    cnt_0++;
                    break;
                }
                if (lottos[i] == win_nums[j]) {
                    cnt++;
                    break;
                }
            }
        }
        answer = new int[2];
        if (7 - (cnt + cnt_0) == 7)
            answer[0] = 6;
        else
            answer[0] = 7 - (cnt + cnt_0);

        if (7 - cnt == 7)
            answer[1] = 6;
        else
            answer[1] = 7 - cnt;
        return answer;
    }
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] result = solution(lottos, win_nums);
        System.out.println(result[0] + "  " + result[1]);
    }
}
