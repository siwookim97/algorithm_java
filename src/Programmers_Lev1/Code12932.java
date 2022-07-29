package Programmers_Lev1;

import java.util.ArrayList;

public class Code12932 {
    public static ArrayList<Integer> solution(long n) {
        ArrayList<Integer> list = new ArrayList<>();

        while (n > 0) {
            list.add((int)(n%10));
            n = n / 10;
        }

        return list;
    }

    public static void main(String[] args) {
        int n = 12345;

        System.out.println(solution(n));
    }
}
