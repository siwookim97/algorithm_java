package Programmers_Lev1;

public class Code77884 {
    public static int solution(int left, int right) {
        int sum = 0;

        for (int i = left; i < right + 1; i++) {
            if (Math.pow((int)Math.sqrt(i), 2) == i)
                sum -= i;
            else
                sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(13, 17));
    }
}
