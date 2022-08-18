package Programmers_Lev2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code12909 {
    static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        if (s.charAt(s.length() - 1) == '(')
            return false;
        if (s.charAt(0) == ')')
            return true;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.add(c);
            }
            else {
                if (!(stack.peek() == c)) {
                    stack.pop();
                }
                else {
                    stack.add(c);
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(solution(")()("));
    }
}
