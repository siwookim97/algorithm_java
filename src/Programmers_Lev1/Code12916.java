package Programmers_Lev1;

public class Code12916 {
    public static boolean solution(String s) {
        int pCnt = 0;
        int yCnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p' || s.charAt(i) == 'P')
                pCnt++;
            else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y')
                yCnt++;
        }

        return pCnt == yCnt ? true : false;
    }

    public static void main(String[] args) {
        String s = "Pyy";

        System.out.println(solution(s));
    }
}
