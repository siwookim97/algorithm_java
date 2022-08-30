package Programmers_Lev2;

public class Code62048 {
    public static long solution(int w, int h) {
        long ref = gcd(w, h);

        return ((long) w * h) - (((w / ref) + (h / ref) - 1) * ref);
    }

    private static int gcd(int n, int m) {
        while (m != 0) {
            int r = n % m;

            n = m;
            m = r;
        }

        return n;
    }

    public static void main(String[] args) {
        System.out.println(solution(100000000, 999999999));
    }
}
