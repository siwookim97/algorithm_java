package Chapter08;

import java.util.Scanner;

public class BFmatch {
    static int bfMatch(String txt, String pat) {
        int pt = 0; // txt 커서
        int pp = 0; // 패턴 커서

        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
        }
        if (pp == pat.length())
            return pt - pp;
        return -1;
    }

    static int bfMatchPrint(String txt, String pat) { // 검사과정을 출력하는 BF
        int pt = 0; // txt 커서
        int pp = 0; // 패턴 커서
        int cnt = 0;

        while (pt != txt.length() && pp != pat.length()) {
            cnt++;

            if (pp == 0) System.out.printf("%2d ", pt); // pt 위치 포인터 출력
            else System.out.print("   ");
            System.out.printf("%s\n", txt);

            System.out.printf("   "); // 기호 출력
            for (int i = 0; i < pt; i++)
                System.out.print(" ");
            System.out.print(txt.charAt(pt) == pat.charAt(pp) ? '+' : '|');
            System.out.println();

            System.out.print("   "); // 패턴 출력
            for (int i = 0; i < pt - pp; i++)
                System.out.print(" ");
            System.out.println(pat);


            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
        }
        System.out.println("비교는 " + cnt + "회 였습니다.");
        if (pp == pat.length())
            return pt - pp;
        return -1;
    }

    static int bfMatchLast(String txt, String pat) { // 텍스트의 가장 뒤쪽의 인덱스를 반환하는 메서드
        int pp = pat.length() - 1;
        int pt = txt.length() - 1;

        while (pt >= 0 && pp >= 0) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pp--;
                pt--;
            }
            else {
                pt = pt + (pat.length() - pp) - 2;
                pp = pat.length() - 1;
            }
        }
        if (pp < 0)
            return pt + 1;
        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int[] a = new int[10];
        System.out.print("텍스트 : ");
        String s1 = stdIn.next();

        System.out.print("패턴 : ");
        String s2 = stdIn.next();
        int idx = bfMatchLast(s1, s2);

        if (idx == -1)
            System.out.println("텍스트에 패턴이 없습니다.");
        else {
            int len = 0;
            for (int i = 0; i < idx; i++)
                len += s1.substring(i, i + 1).getBytes().length;
            len += s2.length();

            System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트 : " + s1);
            System.out.printf(String.format("패턴 : %%%ds\n", len), s2);
        }
    }
}
