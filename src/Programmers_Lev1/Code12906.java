package Programmers_Lev1;

import java.util.ArrayList;

public class Code12906 {
    public static ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                list.add(arr[i]);
            }
            else {
                if (!list.get(list.size() - 1).equals(arr[i])) {
                    list.add(arr[i]);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};

        Object[] sol = solution(arr).toArray();

        for (Object i : sol) {
            System.out.println(i);
        }
    }
}
