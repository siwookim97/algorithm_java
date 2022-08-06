package Programmers_Lev1;

public class Code87389 {
    public static int solution(int n) {
        int answer = 0;

        for (int i = 2; i < n; i++) {
            if (n % i == 1)
                return i;
        }

        return n - 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(12));
    }
}
