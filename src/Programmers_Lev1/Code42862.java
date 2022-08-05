package Programmers_Lev1;

import java.util.Arrays;

public class Code42862 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];

        for(int i = 0; i < n; i++) {
            students[i]++;
        }

        for(int l : lost) {
            students[l-1]--;
        }

        for(int r : reserve) {
            students[r-1]++;
        }

        for(int i = 0; i < n; i++) {
            if (i-1 >= 0 && students[i-1] == 0 && students[i] >= 2) {
                students[i-1]++;
                students[i]--;
            }
            if (i+1 < n && students[i+1] == 0 && students[i] >= 2) {
                students[i+1]++;
                students[i]--;
            }
        }

        return (int)Arrays.stream(students).filter(student -> student >= 1).count();

    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {1,3,4};
        int[] reserve = {1,3,5};

        System.out.println(solution(n, lost, reserve));
    }
}
