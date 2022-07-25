package Programmers_Lev1;

public class Code12926 {
    public static String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char str = s.charAt(i);
            if (str == ' ') {
                sb.append(' ');
            } else {
                for (int j = 0; j < n; j++) {
                    if (str == 'z' || str == 'Z') {
                        str = (char) (str - 26 + 1);
                    } else {
                        str = (char) (str + 1);
                    }
                }
                sb.append(str);
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "abcdefghijk    lmnz";
        int n = 25;

        System.out.println(solution(s, n));
    }
}
