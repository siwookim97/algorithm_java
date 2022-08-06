package Programmers_Lev1;

public class Code68935 {
    public static int solution(int n) {
        StringBuilder sb = new StringBuilder();
        int result = 0;
        int cnt = 0;

        for (int i = n; i > 0; i/=3) {
            sb.append(i%3);
        }

        sb.reverse();

        for (int i = 0; i < sb.length(); i++) {
            result += (int)Math.pow(3, i) * (sb.charAt(i) - '0');
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(solution(45));
    }
}
