package Programmers_Lev1;

public class Code86491 {
    public static int solution(int[][] sizes) {
        int xMax = 0;
        int yMax = 0;

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            if (sizes[i][0] > xMax)
                xMax = sizes[i][0];
            if (sizes[i][1] > yMax)
                yMax = sizes[i][1];
        }

        return xMax * yMax;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{60,50}, {30,70}, {60,30}, {80,40}}));
    }
}
