package Programmers_Lev1;

import java.util.ArrayList;

public class Code17681 {
    public static ArrayList<String> solution(int n, int[] arr1, int[] arr2) {
        ArrayList<String> list = new ArrayList<>();
        int num1, num2;
        StringBuilder sb;
        for (int i = 0; i < n; i++) {
            num1 = arr1[i];
            num2 = arr2[i];
            sb = new StringBuilder();
            for (int j = n - 1; j >= 0; j--) {
                int pow = (int)Math.pow(2, j);
                if (num1 < pow && num2 < pow) {
                    sb.append(' ');
                }
                else if (num1 >= pow && num2 >= pow) {
                    sb.append('#');
                    num1 -= pow;
                    num2 -= pow;
                }
                else if (num1 >= pow && num2 < pow) {
                    sb.append('#');
                    num1 -= pow;
                }
                else {
                    sb.append('#');
                    num2 -= pow;
                }
            }
            list.add(sb.toString());
        }

        return list;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        for (String str : solution(n, arr1, arr2)) {
            System.out.println(str);
        }
    }
}
