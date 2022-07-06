package Programmers_Lev1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code70128 {
    public static int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += (a[i] * b[i]);
            System.out.println(answer);
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr1 = new int[4];
        int[] arr2 = new int[4];
        for (int i = 0; i < 4; i++) {
            arr1[i] = Integer.parseInt(br.readLine());
            arr2[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < 4; i++) {
            System.out.println("arr1 : " + arr1[i]);
            System.out.println("arr2: " + arr2[i]);

        }
        System.out.println(solution(arr1, arr2));
    }
}
