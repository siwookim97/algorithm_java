package Programmers_Lev2;

import java.util.*;

public class Code42626 {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        int cnt = 0;
        for (int i = 0; i < scoville.length; i++) {
            que.add(scoville[i]);
        }

        while (que.peek() < K) {
            if (que.size() == 1) {
                return -1;
            }
            int a = que.poll();
            int b = que.poll();
            int input = a * 2 + b;
            que.add(input);
            cnt++;
        }



        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}
