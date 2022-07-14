package Programmers_Lev1;

import java.util.Locale;

public class Code72410 {
    public static String solution(String new_id) {
        new_id = new_id.toLowerCase(Locale.ROOT);

        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        new_id = new_id.replaceAll("[.]{2,}", ".");

        if (new_id.length() > 0 && new_id.charAt(0) == '.') {
            new_id = new_id.substring(1, new_id.length());
        }

        if (new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        if (new_id.length() == 0)
            new_id = "a";

        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);

            if (new_id.charAt(new_id.length() - 1) == '.')
                new_id = new_id.substring(0, new_id.length() - 1);
        }

        if (new_id.length() <= 2) {
            char lastChar = new_id.charAt(new_id.length() - 1);

            while (new_id.length() < 3) {
                new_id += lastChar;
            }
        }

        return new_id;
    }

    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(solution(new_id));
    }
}
