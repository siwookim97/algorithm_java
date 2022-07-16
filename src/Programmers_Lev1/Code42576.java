package Programmers_Lev1;

import java.util.HashMap;
import java.util.Map;

public class Code42576 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i]) - 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) > 0){
                answer = key;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        System.out.println(solution(participant, completion));
    }
}
