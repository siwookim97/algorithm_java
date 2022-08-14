package Programmers_Lev2;

import java.util.Arrays;
import java.util.Collections;

public class Code42747 {
    public static int solution(int[] citations) {
        int N=citations.length;
        Integer []temp=new Integer[N];
        for (int i = 0; i < N; i++) {
            temp[i]=citations[i];
        }
        int answer=0;
        Arrays.sort(temp,Collections.reverseOrder());

        while(answer<N){
            if(temp[answer]<=answer)break;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,0,6,1,5}));
    }
}
