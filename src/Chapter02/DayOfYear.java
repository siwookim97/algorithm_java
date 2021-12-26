package Chapter02;

import java.util.Scanner;

public class DayOfYear {
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
    };

    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    static int dayOfYear(int y, int m, int d) {
        while (m >= 2) {
            d += mdays[isLeap(y)][m - 2];
            m--;
        }
        return d;
    }

    static int leftDayOfYear(int y, int m, int d) {
        while(m >= 2) {
            d += mdays[isLeap(y)][m-2];
            m--;
        }
        return (365+isLeap(y)-d);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int retry;

        System.out.println("그 해의 경과 일수를 구합니다.");

        do {
            System.out.print("년 : ");
            int year = stdIn.nextInt();
            System.out.print("월 : ");
            int month = stdIn.nextInt();
            System.out.print("일 : ");
            int day = stdIn.nextInt();
            System.out.printf("그 해 %d일째 입니다. \n", dayOfYear(year, month, day));
            System.out.printf("그 해 %d일이 남았습니다. \n", leftDayOfYear(year, month, day));

            System.out.print("한 번 더 할까요? (1. YES/2. NO)");
            retry = stdIn.nextInt();
        } while (retry == 1);
    }
}
