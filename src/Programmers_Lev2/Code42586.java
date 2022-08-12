package Programmers_Lev2;

import java.util.*;

public class Code42586 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            days[i] = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0)
                days[i]++;
            que.add(days[i]);
        }

        int temp = que.poll();
        int cnt = 1;
        while (!que.isEmpty()) {
            int peek = que.peek();
            if (temp < peek) {
                list.add(cnt);
                temp = peek;
                cnt = 1;
            }
            else {
                cnt++;
            }
            que.poll();
            if (que.isEmpty())
                list.add(cnt);
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1,1,1,1,1,1});
        System.out.println("length : " + arr.length);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
