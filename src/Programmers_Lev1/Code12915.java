package Programmers_Lev1;

public class Code12915 {
    public static boolean compare(String str1, String str2) { // true이면 안바꾸고 false이면 바꿈
        for (int i = 0; i < (str1.length() > str2.length() ? str2.length() : str1.length()); i++) {
            if (str1.charAt(i) > str2.charAt(i))
                return false;
            else if (str1.charAt(i) < str2.charAt(i))
                return true;
        }

        // 같은 문자열이면 안바꿈
        return true;
    }

    public static String[] solution(String[] strings, int n) {
        String temp;

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < (strings.length - i) - 1; j++) {
                char ch1 = strings[j].charAt(n);
                char ch2 = strings[j + 1].charAt(n);
                if (ch1 > ch2) {
                    temp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = temp;
                }
                else if (ch1 == ch2) {
                    if (!compare(strings[j], strings[j + 1])) {
                        temp = strings[j];
                        strings[j] = strings[j + 1];
                        strings[j + 1] = temp;
                    }
                }
            }
        }

        return strings;
    }

    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 1;

        String[] str = solution(strings, n);
        for (String s :str) {
            System.out.println(s);
        }
    }
}
