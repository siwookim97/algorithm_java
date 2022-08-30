package Programmers_Lev2;

public class Code12951 {
    public static String solution(String s) {
        String str = s.toLowerCase();
        StringBuilder sb = new StringBuilder(str);

        boolean tf = true;
        for (int i = 0; i < str.length(); i++) {
            if ((tf == true && (sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z'))) {
                sb.setCharAt(i, (char)(sb.charAt(i) - 'a' + 'A'));
                tf = false;
            }
            if ((tf == true && !(sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z'))) {
                tf = false;
            }
            if (sb.charAt(i) == ' ')
                tf = true;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
    }
}
