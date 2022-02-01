package Chapter08;

import java.util.Scanner;

public class BMMatch {
    static int bmMatch(String txt, String pat) {
        int pt; // txt 커서
        int pp; // pat 커서
        int txtLen = txt.length(); // txt의 문자 개수
        int patLen = pat.length(); // pat의 문자 개수
        int[] skip = new int[Character.MAX_VALUE + 1]; // 건너뛰기 표

        for (pt = 0; pt < Character.MAX_VALUE; pt++)
            skip[pt] = patLen; // 건너뛰기 표를 patLen으로 초기화
        for (pt = 0; pt < patLen - 1; pt++)
            skip[pat.charAt(pt)] = patLen - pt - 1;

        while (pt < txtLen) { // 검색
            pp = patLen - 1;

            while (txt.charAt(pt) == pat.charAt(pp)) {
                if (pp == 0)
                    return pt;
                pp--;
                pt--;
            }
            pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);



        System.out.println("======Boyer-Moore======");
        System.out.print("텍스트 : ");
        String s1 = stdIn.next();

        System.out.print("패턴 : ");
        String s2 = stdIn.next();

        int idx = bmMatch(s1, s2);

        System.out.println((idx + 1) + "번째 문자부터 일치 합니다.");
        System.out.println("텍스트 : "  + s1);
        System.out.println("패턴 : " + s2);
    }
}
