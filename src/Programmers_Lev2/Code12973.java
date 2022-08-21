package Programmers_Lev2;

import java.util.Stack;

public class Code12973 {
    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
            }
            else {
                Character peek = stack.peek();
                if (peek == ch) {
                    stack.pop();
                }
                else {
                    stack.push(ch);
                }
            }
        }

        if (stack.isEmpty()) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("cdcd"));
    }
}
