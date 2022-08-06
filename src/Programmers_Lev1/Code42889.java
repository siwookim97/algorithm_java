package Programmers_Lev1;

import java.util.*;

public class Code42889 {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> map = new HashMap<>();

        int userNum = stages.length;

        int j = 0;
        Arrays.sort(stages);
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (; j < stages.length; j++) {
                if (userNum == 0)
                    break;
                if ((i + 1) == stages[j]) {
                    cnt++;
                }
                else {
                    break;
                }
            }
            if (userNum == 0) {
                map.put(i, (double) 0);
            }
            else {
                map.put(i, (double) cnt / userNum);
            }
            userNum -= cnt;
        }

        List<Integer> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        for (int i = 0; i < N; i++) {
            answer[i] = (keySetList.get(i) + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {3,3,3,3};

        for (int i : solution(N, stages)) {
            System.out.println(i);
        }
    }
}
