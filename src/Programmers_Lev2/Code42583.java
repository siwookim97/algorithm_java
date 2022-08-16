package Programmers_Lev2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code42583 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int w = 0;
        Queue<Integer> que = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        List<Integer> list = new ArrayList<>(); // 나온 것의 수

        for (int i = 0; i < truck_weights.length; i++) {
            que.add(truck_weights[i]);
        }
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        // 1. que에서 빼서 peek으로 확인
        // 2. peek한 것을 w에 더해 weight보다 작으면 que에서 poll해서 bridge에 넣기, bridge의
        // 3. 넣을 수 없으면 bridge에서 빼고 0을 다시 넣고 w를 조정
        while (!que.isEmpty()) {
            int quePeek = que.peek();
            int bridgePeek = bridge.peek().intValue();

            if (w + quePeek - bridgePeek <= weight) { // 넣을 수 있으면
                int bridgePoll = bridge.poll().intValue();
                bridge.add(que.poll());
                w = w + quePeek - bridgePeek;
                if (bridgePoll != 0) {
                    list.add(bridgePoll);
                }
            }
            else { // 넣을 수 없으면
                int bridgePoll = bridge.poll().intValue();
                bridge.add(0);
                w = w - bridgePeek;
                if (bridgePoll != 0) {
                    list.add(bridgePoll);
                }
            }
            answer++;
        }


        return answer + bridge_length;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7,4,5,6}));
    }
}
