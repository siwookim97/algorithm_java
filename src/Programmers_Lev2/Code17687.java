package Programmers_Lev2;

public class Code17687 {
    public static void append(StringBuilder sb, int num, int n) {
        if ((num % n) == 10) {
            sb.append('A');
        }
        else if ((num % n) == 11){
            sb.append('B');
        }
        else if ((num % n) == 12) {
            sb.append('C');
        }
        else if ((num % n) == 13) {
            sb.append('D');
        }
        else if ((num % n) == 14) {
            sb.append('E');
        }
        else if ((num % n) == 15) {
            sb.append('F');
        }
        else {
            sb.append(num % n);
        }
    }

    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        sb.append(0);
        for (int i = 1; i < t * m; i++) {
            int num = i;
            StringBuilder sbNum = new StringBuilder();
            while (num > 0) {
                if (num > n - 1) {
                    append(sbNum, num, n);
                    num = num / n;
                } else {
                    append(sbNum, num, n);
                    num = 0;
                }
            }
            sbNum.reverse();
            sb.append(sbNum);
        }

        for (int i = p - 1; i < t * m; i = i + m) {
            answer += sb.charAt(i);
        }


        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(16,16,2,2));
    }
}
