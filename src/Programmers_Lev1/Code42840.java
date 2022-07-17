package Programmers_Lev1;

import java.util.ArrayList;

public class Code42840 {
    public static int[] solution(int[] answers) {
        String str1 = "12345";
        String str2 = "21232425";
        String str3 = "3311224455";
        int[] score = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == Integer.parseInt(str1.charAt(i % str1.length()) + "")) {
                score[0]++;
            }
            if (answers[i] == Integer.parseInt(str2.charAt(i % str2.length()) + "")) {
                score[1]++;
            }
            if (answers[i] == Integer.parseInt(str3.charAt(i % str3.length()) + "")) {
                score[2]++;
            }
        }

        // 하이스코어 구한 뒤 하이스코어와 가까운 값은 배열에 넣어주기
        int highScore = 0;
        for (int i = 0; i < 3; i++) {
            if (score[i] > highScore) {
                highScore = score[i];
            }
        }

        ArrayList<Integer> spjNumAl = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(highScore == score[i]) {
                spjNumAl.add(i + 1);
            }
        }

        // ArrayList에 담긴 정보 Array에 입력
        int[] answer = new int[spjNumAl.size()];
        for(int i = 0; i < spjNumAl.size(); i++) {
            answer[i] = spjNumAl.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};

        int[] answer = solution(answers);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
