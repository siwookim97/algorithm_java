package Programmers_Lev1;

import java.util.ArrayList;

public class Code12928 {
    public static int solution(int n) {
        int sum = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum += (n / i);
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int n = 12;

        System.out.println(solution(n));
    }
}
