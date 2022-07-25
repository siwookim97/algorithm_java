package Programmers_Lev1;

import java.util.ArrayList;

public class Code12954 {
    public static ArrayList<Long> solution(int x, int n) {
        ArrayList<Long> list = new ArrayList<>();
        long num = x;

        for (int i = 0; i < n; i++) {
            list.add(num);
            num += x;
        }

        return list;
    }

    public static void main(String[] args) {
        int x = 2;
        int n = 5;

        System.out.println(solution(x, n));
    }
}
