package Programmers_Lev1;

import java.io.IOException;
import java.util.*;

public class Code92334 {
    public static int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Set<String>> to_from = new HashMap<>(); // 누구한테 신고를 받았는지
        HashMap<String, Integer> report_num = new HashMap<>(); // 신고당한 횟수
        HashMap<String, Integer> index = new HashMap<>();
        int[] arr = new int[id_list.length];

        StringTokenizer st;
        for (int i = 0; i < id_list.length; i++) {
            Set<String> set = new HashSet<>();
            to_from.put(id_list[i], set);
            report_num.put(id_list[i], 0);
            index.put(id_list[i], i);
        }

        for (int i = 0; i < report.length; i++) {
            st = new StringTokenizer(report[i], " ");
            String from = st.nextToken();
            String to = st.nextToken();

            // report_num
            if (!to_from.get(to).contains(from)) {
                Integer num = report_num.get(to) + 1;
                report_num.replace(to, num);
            }
            // to_from
            Set<String> set = to_from.get(to);
            set.add(from);
            to_from.replace(to, set);
        }

        for (int i = 0; i < id_list.length; i++) {
            if (report_num.get(id_list[i]) >= k) {
                Set<String> set = to_from.get(id_list[i]);
                for (int j = 0; j < id_list.length; j++) {
                    if (set.contains(id_list[j])) {
                        arr[index.get(id_list[j])]++;
                    }
                }
            }
        }

        return arr;
    }
    public static void main(String[] args) throws IOException {
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};

        System.out.println();
        int[] answer = solution(id_list, report, 2);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
