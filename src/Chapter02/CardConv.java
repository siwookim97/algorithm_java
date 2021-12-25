package Chapter02;

import java.util.Scanner;

public class CardConv {
    static int cardConv(int x, int r, char[] d) { // x는 정수값, r는 기수, d는 변환된 진수
        int digits = 0;
        String dChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = dChar.charAt(x % r);
            x /= r;
        } while (x != 0);

        for (int i = 0; i < digits / 2; i++) {
            char t = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = t;
        }

        return digits;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int x; // 넣을 정수값
        char[] d = new char[32];
        int r; // 바꿀 기수값
        int retry;
        int digits; // 바뀐 숫자의 자릿수

        do {
            do {
                System.out.print("양의 10진수를 입력하세요 : ");
                x = stdIn.nextInt();
            } while (x < 0);

            do {
                System.out.print("몇진수로 변경하시겠습니까? (2~32): ");
                r = stdIn.nextInt();
            } while (r < 2 || r > 32);

            digits = cardConv(x, r, d);
            System.out.print(r + "진수 변환의 결과는 : ");
            for (int i = 0; i < digits; i++) {
                System.out.print(d[i] + " ");
            }
            System.out.println("입니다.");

            do {
                System.out.print("한 번 더 진수변환을 하시겠습니까? (1.YES, 2.NO)");
                retry = stdIn.nextInt();
            } while(retry != 1 && retry != 2);
        } while (retry != 2);
    }
}
