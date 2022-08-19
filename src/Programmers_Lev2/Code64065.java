package Programmers_Lev2;

import java.util.*;

// 튜플 Lev.2
public class Code64065 {
    public static int[] solution(String s) {
        // {이 나오면 cnt++, }이 나오면 cnt--, cnt가 0이면 새로운거 받아옴
        List<String> list = new ArrayList<>();
        String str = "";
        boolean bracket = true;
        Integer cnt = 0;
        Map<Integer, List<String>> map = new HashMap<>();
        Queue<String> que = new LinkedList<>();

        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '{') {
                bracket = false;
                list = new ArrayList<>();
                cnt = 0;
                str = "";
            }
            else if (s.charAt(i) == '}'){
                bracket = true;
                cnt = cnt + 1;
                list.add(str);
                map.put(cnt, list);
                str = "";
                System.out.println();

            }
            else if (s.charAt(i) == ',') {
                if (!bracket) {
                    cnt = cnt + 1;
                    list.add(str);
                    str = "";
                }
            }
            else { // 숫자
                str += s.charAt(i);
            }
        }

        for (int i = 1; i < map.size() + 1; i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if (!que.contains(map.get(i).get(j))) {
                    que.add(map.get(i).get(j));
                }
            }
        }

        int[] result = new int[map.size()];
        int size = que.size();
        for (int i = 0; i < size; i++) {
            result[i] = Integer.parseInt(que.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
