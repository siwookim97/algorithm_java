package Chapter02;

import java.util.Scanner;

public class YearMonthDay {
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
    };

    static int isLeap(int year) {
        return (year % 4 == 0 && year % 400 != 0 || year % 100 == 0) ? 1 : 0;
    }

    static class YMD {
        int y;
        int m;
        int d;

        YMD(int y, int m, int d) {
            this.y = y;
            this.m = m;
            this.d = d;
        }

        public YMD after(int n) {
            YMD temp = this;

            if (n < 0) {
                return (before(-n));
            }

            temp.d += n;
            while (mdays[isLeap(temp.y)][temp.m - 1] < temp.d) {
                if (temp.m == 12) {
                    temp.d -= mdays[isLeap(temp.y)][temp.m - 1];
                    temp.y++;
                    temp.m = 1;
                } else {
                    temp.d -= mdays[isLeap(temp.y)][temp.m - 1];
                    temp.m += 1;
                }
            }

            return temp;
        }

        public YMD before(int n) {
            YMD temp = this;

            if (n < 0) {
                return (after(-n));
            }

            temp.d -= n;
            while (temp.d <= 0) {
                if (temp.m == 1) {
                    temp.d += mdays[isLeap(temp.y)][temp.m - 2];
                    temp.y--;
                    temp.m = 12;
                } else {
                    temp.d += mdays[isLeap(temp.y)][temp.m - 2];
                    temp.m;
                }
            }
            return temp;
        }

        public static void main(String[] args) {
            Scanner stdIn = new Scanner(System.in);
            int x;
            int retry;

            System.out.print("년 : ");
            int y = stdIn.nextInt();
            System.out.print("월 : ");
            int m = stdIn.nextInt();
            System.out.print("일 : ");
            int d = stdIn.nextInt();
            YMD ymd = new YMD(y, m, d);

            do {
                System.out.print("지정한 날짜의 뒤를 보시겠습니까 앞을 보시겠습니까? (1. 앞,2. 뒤)");
                x = stdIn.nextInt();
            } while (x != 1 && x != 2);
            System.out.print("며칠을 보시겠습니까? : ");
            int n = stdIn.nextInt();
            YMD temp = null;

            if (x == 1) {
                temp = ymd.before(n);
            } else {
                temp = ymd.after(n);
            }

            System.out.printf("바뀐 날짜는 %d년 %d월 %d일 입니다.\n", temp.y, temp.m, temp.d);

        }
    }
}
