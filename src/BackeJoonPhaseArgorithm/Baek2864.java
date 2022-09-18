package BackeJoonPhaseArgorithm;

import java.util.Scanner;

public class Baek2864 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String a = sc.next();
        String b = sc.next();
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();

        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] == '6')
                arrA[i] = '5';
        }

        for (int i = 0; i < arrB.length; i++) {
            if (arrB[i] == '6')
                arrB[i] = '5';
        }

        int smallA = Integer.parseInt(String.valueOf(arrA));
        int smallB = Integer.parseInt(String.valueOf(arrB));
        sb.append(smallA + smallB + " ");

        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] == '5')
                arrA[i] = '6';
        }

        for (int i = 0; i < arrB.length; i++) {
            if (arrB[i] == '5')
                arrB[i] = '6';
        }

        int bigA = Integer.parseInt(String.valueOf(arrA));
        int bigB = Integer.parseInt(String.valueOf(arrB));
        sb.append(bigA + bigB);

        System.out.println(sb);
    }
}
