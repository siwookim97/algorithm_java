package Programmers_Lev1;

public class Code12921 {
    public static boolean isPrime(int n) {
        for (int j = 2; j * j <= n; j++) {
            if (n % j == 0)
                return false;
        }
        return true;
    }


    public static int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i))
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println(solution(n));
    }
}
