package Programmers_Lev2;

import java.util.ArrayList;
import java.util.HashMap;

public class Code42578 {
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < clothes.length; i++) {
            if (!hash.containsKey(clothes[i][1])) {
                hash.put(clothes[i][1], 2);
                list.add(clothes[i][1]);
            }
            else {
                hash.replace(clothes[i][1], hash.get(clothes[i][1]) + 1);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            answer *= hash.get(list.get(i));
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}}));
    }
}
