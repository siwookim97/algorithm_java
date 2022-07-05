package BackeJoonPhaseArgorithm;

import java.io.*;

public class Baek1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] arr = new int[26]; // 문자가 몇개 들어있는지 확인하는 배열
        int odd; // 배열의 어디에 홀수개가 들어있는지 확인하는 변수
        int cntOdd = 0;
        boolean tf = false;

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'A']++;
        }

        // 홀수개 있는 문자 탐색
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                cntOdd++;
                odd = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        String result = "";
        if (cntOdd > 1) {
            sb.append("I'm Sorry Hansoo");
            result += sb.toString();
        }
        else {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i]/2; j++) {
                    sb.append((char)(i + 65));
                }
            }
            result += sb.toString();
            String rev = sb.reverse().toString();

            sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 1) {
                    sb.append((char)(i + 65));
                }
            }
            result += sb.toString() + rev;
        }

        System.out.println(result);

    }
}
