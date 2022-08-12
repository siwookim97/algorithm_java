package Programmers_Lev2;

public class Code12899 {
    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int remain = n % 3;
            n = n / 3;
            if (remain == 0) {
                sb.append(4);
                n--;
            }
            else if (remain == 1)
                sb.append(1);
            else
                sb.append(2);
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
    }
}
