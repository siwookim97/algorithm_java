package Programmers_Lev2;

public class Code60057 {
    public static int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) { // i는 나누는 개수
            int cnt = 0;
            StringBuilder sb = new StringBuilder(); // 압축한 문자열
            String pattern = s.substring(0, i); // 패턴

            for (int j = i; j < s.length(); j += i) {
                if (j + i > s.length()) {
                    sb.append(s.substring(j));
                    break;
                }
                if (pattern.equals(s.substring(j, j + i))) {
                    cnt++;
                } else {
                    if (cnt > 0) {
                        sb.append(cnt + 1);
                        sb.append(pattern);
                        cnt = 0;
                    } else {
                        sb.append(pattern);
                    }
                    pattern = s.substring(j, j + i);
                }
            }

            if (cnt > 0) {
                sb.append(cnt + 1);
                sb.append(pattern);
            } else {
                sb.append(pattern);
            }
            answer = Math.min(sb.length(), answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcabcdede"));
    }
}
