package Programmers_Lev2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Code12939 {
    public static String solution(String s) {
        String answer = "";
        String str = "";
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch == ' ') {
                list.add(Integer.parseInt(str));
                str = "";
            }
            else if (ch == '-') {
                str += "-";
            }
            else if (i == s.length() - 1) {
                str += ch;
                list.add(Integer.parseInt(str));
            }
            else {
                str += ch;
            }
        }
        Collections.sort(list);
        answer += list.get(0);
        answer += " " + list.get(list.size() - 1);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
    }
}
