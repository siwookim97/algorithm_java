package Chapter08;

import java.util.Scanner;

public class KMPMatch {
    static int kmpMatch(String txt, String pat) {
        int pt = 1;
        int pp = 0;
        int[] skip = new int[pat.length() + 1];

        skip[pt] = 0;
        while (pt != pat.length()) {
            if (pat.charAt(pt) == pat.charAt(pp))
                skip[++pt] = ++pp;
            else if (pp == 0)
                skip[++pt] = pp;
            else
                pp = skip[pp];
        }

        // 검색
        pt = pp = 0;
        while (pt != txt.length() && pp != pat.length()) {
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
            } else if (pp == 0)
                pt++;
            else
                pp = skip[pp];
        }

        if (pp == pat.length())
            return pt - pp;
        return  -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("txt를 입력 : ");
        String txt = stdIn.next();

        System.out.print("pattern을 입력 : ");
        String pat = stdIn.next();

        int idx = kmpMatch(txt, pat);

        System.out.println("찾고자 하는 인덱스는 " + (idx + 1) + "부터 시작합니다.");
    }
}
