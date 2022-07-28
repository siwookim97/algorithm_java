package Programmers_Lev1;

public class Code12947 {
    public static boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        int n = x;

        while(n >= 10) {
            sum = sum + (n % 10);
            n = n / 10;
        }
        sum += n;

        if (x % sum == 0) {
            answer = true;
        }
        else {
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        int x = 12;

        System.out.println(solution(x));
    }
}