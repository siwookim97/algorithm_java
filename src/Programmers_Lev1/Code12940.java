package Programmers_Lev1;

public class Code12940 {
    public static int[] solution(int n, int m) {
        int[] answer = new int[2];
        int num1, num2;
        if (n > m) {
            num2 = n;
            num1 = m;
        }
        else {
            num1 = n;
            num2 = m;
        }

        for (int i = num1; i >= 1; i--) {
            if ((num1 % i == 0) && (num2 % i == 0)) {
                answer[0] = i;
                break;
            }
        }

        for (int i = num2; i <= num1 * num2;) {
            if ((i % num1 == 0) && (i % num2 == 0)) {
                answer[1] = i;
                break;
            }
            i += num2;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 12;

        System.out.println(solution(n, m));
    }
}
