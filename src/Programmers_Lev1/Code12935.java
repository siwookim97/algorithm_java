package Programmers_Lev1;

import java.util.ArrayList;

public class Code12935 {
    public static ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int min = 10000;
        int idx = -1;

        if (arr.length == 1) {
            list.add(-1);
            return list;
        }

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                idx = i;
            }
            list.add(arr[i]);
        }
        list.remove(idx);

        return list;
    }

    public static void main(String[] args){
        int[] arr = {10};

        System.out.println(solution(arr));
    }
}
