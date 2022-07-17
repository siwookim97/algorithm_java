package Programmers_Lev1;

public class Code12901 {
    public static String solution(int a, int b) {
        int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};

        int cnt = 0;
        for (int i = 0; i < a - 1; i++) {
            cnt += month[i];
        }
        cnt += b;

        String answer = day[(cnt - 1) % day.length];

        return answer;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        System.out.println(solution(a, b));
    }
}
