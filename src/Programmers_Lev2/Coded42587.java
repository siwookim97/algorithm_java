package Programmers_Lev2;

import java.util.*;

public class Coded42587 {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            que.add(priorities[i]);
            list.add(priorities[i]);
        }
        Collections.sort(list, Collections.reverseOrder());


        while (!que.isEmpty()) {
            int peek = que.peek();

            if (list.get(0).equals(peek) && location == 0) {
                return answer + 1;
            }
            else if (list.get(0).equals(peek) && location != 0) {
                location--;
                que.poll();
                list.remove(0);
                answer++;
            }
            else if (!list.get(0).equals(peek) && location == 0) {
                location = que.size() - 1;
                int enque = que.poll();
                que.add(enque);
            }
            else { // 같지 않고 찾고자 하는 로케이션이 아님
                location--;
                int enque = que.poll();
                que.add(enque);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,1,9,1,1,1}, 0));
    }
}
