package Programmers_Lev1;

public class Code12943 {
    public static int solution(long num) {
        int ci = 0;

        while (ci < 500 && num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            ci++;
            System.out.println(num + " " + ci);
        }
        if (ci == 500) {
            ci = -1;
        }
        return ci;
    }

    public static void main(String[] args) {
        int num = 626331;

        System.out.println(solution(num));
    }
}
