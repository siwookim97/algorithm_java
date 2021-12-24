package Chapter02;

import java.util.Random;
import java.util.Scanner;

public class RandomArray {
    static int maxOf(int[] a) {
        int max = a[0];

        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) max = a[i];
        }

        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner stdIn = new Scanner(System.in);

        System.out.println("키의 최댓값을 구합니다.");
        int num = 1 + rand.nextInt(10);
        System.out.println("사람의 수는 " + num + "입니다.");
        int[] height = new int[num];

        for (int i = 0; i < num; i++) {
            height[i] = 100 + rand.nextInt(90);
            System.out.println(i + 1 + "번째 사람의 키는 " + height[i] + "입니다.");
        }

        System.out.println("가장 큰 키는 " + maxOf(height) + "입니다.");
    }
}
