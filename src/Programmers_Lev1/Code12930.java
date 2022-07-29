package Programmers_Lev1;

public class Code12930 {
    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                cnt = 0;
                sb.append(" ");
                continue;
            }
            if (cnt % 2 == 0 & s.charAt(i) != ' ') {
                String str = (s.charAt(i) + "").toUpperCase();
                sb.append(str);
                cnt++;
            }
            else {
                String str = (s.charAt(i) + "").toLowerCase();
                sb.append(str);
                cnt++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "try hello world";

        System.out.println(solution(str));
    }
}
