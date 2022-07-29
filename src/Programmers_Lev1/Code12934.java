package Programmers_Lev1;

public class Code12934 {
    public static long solution(long n) {
         if (Math.sqrt(n) % 1 == 0) {
             return ((long)Math.sqrt(n) + 1) * ((long)Math.sqrt(n) + 1);
         }
         else {
             return -1;
         }
    }

    public static void main(String[] args) {
        long n = 121;

        System.out.println(solution(n));
    }
}
