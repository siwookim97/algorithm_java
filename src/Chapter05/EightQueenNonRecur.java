package Chapter05;

public class EightQueenNonRecur {
    static int[] pos = new int[8];
    static boolean[] flag_a = new boolean[8]; // 행 뱡향 대각선 중복확인
    static boolean[] flag_b = new boolean[15]; // / 방향 대각선 중복확인
    static boolean[] flag_c = new boolean[15]; // \ 방향 대각선 중복확인

    static void print() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == pos[i])
                    System.out.print("7 ");
                else
                    System.out.print("0 ");
            }
            System.out.println();

        }
        System.out.println();
    }

    static void set(int i) {
        while (i != 8) {
            for (int j = 0; j < 8; j++) {
                if (flag_a[j] == false && flag_b[i + j] == false && flag_c[i - j + 7] == false) {
                    pos[i] = j;

                    if (i == 7) {
                        print();
                        break;
                    } else {
                        flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
                        i += 1;
                        flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}
