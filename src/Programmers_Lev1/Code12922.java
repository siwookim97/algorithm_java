package Programmers_Lev1;

public class Code12922 {
    public static String solution(int n) {
        String answer = "";
        String waterMelon = "수박";

        for (int i = 0; i < n; i++) {
            answer += waterMelon.charAt(i % waterMelon.length());
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(solution(n));
    }
}
