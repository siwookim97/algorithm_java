package Programmers_Lev2;

import java.util.HashMap;
import java.util.Map;

public class Code49993 {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < skill.length(); i++) {
            map.put(skill.charAt(i), i + 1);
        }

        for (int i = 0; i < skill_trees.length; i++) {
            int index = 1;
            for (int j = 0; j < skill_trees[i].length(); j++) {
                char ch = skill_trees[i].charAt(j);
                if (map.containsKey(ch)) { // 스킬트리에 있으면
                    int value = map.get(ch).intValue();
                    if (value == index) {
                        index++;
                    }
                    else {
                        break;
                    }
                }
                if (j == skill_trees[i].length() - 1) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("CBC", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
