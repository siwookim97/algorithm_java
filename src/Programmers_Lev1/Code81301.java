package Programmers_Lev1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code81301 {
    public static int solution(String s) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if ((int)s.charAt(i) - '0' < 10) {
                sb.append(s.charAt(i));
            }
            else {
                str += s.charAt(i);
                for (int j = 0; j < 10; j++) {
                    if (str.equals(arr[j])) {
                        sb.append(j);
                        str = "";
                    }
                }
            }
        }

        answer = Integer.parseInt(sb.toString());

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }
}
