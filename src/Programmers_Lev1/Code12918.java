package Programmers_Lev1;

public class Code12918 {
    public static boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) {
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i)))
                    return false;
            }
        }
        else
            return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "234";

        System.out.println(solution(s));
    }
}
