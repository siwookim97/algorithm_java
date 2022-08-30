package Programmers_Lev2;

public class Code12911 {
    public static int solution(int n) {
        int answer = 0;
        int nowCount = Integer.bitCount(n);

        while(true){
            n++;
            int nextCount = Integer.bitCount(n);

            if(nowCount == nextCount){
                break;
            }
        }

        answer = n;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}
