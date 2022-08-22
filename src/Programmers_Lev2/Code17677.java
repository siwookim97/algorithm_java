package Programmers_Lev2;

import java.util.ArrayList;
import java.util.List;

public class Code17677 {
    public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        str1 = str1.replaceAll("[^a-zA-Z]", " ");
        str2 = str2.replaceAll("[^a-zA-Z]", " ");

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> union = new ArrayList<>();
        List<String> intersection = new ArrayList<>();


        for (int i = 0; i < str1.length() - 1; i++) {
            if (!(str1.charAt(i) == ' ' || str1.charAt(i + 1) == ' ')) {
                String str = "" + str1.charAt(i) + str1.charAt(i + 1);
              //  System.out.println(str);
                list1.add(str);
            }
        }
        System.out.println();
        for (int i = 0; i < str2.length() - 1; i++) {
            if (!(str2.charAt(i) == ' ' || str2.charAt(i + 1) == ' ')) {
                String str = "" + str2.charAt(i) + str2.charAt(i + 1);
             //   System.out.println(str);
                list2.add(str);
            }
        }

        if (list1.size() >= list2.size()) {
            while (!list1.isEmpty()) {
                if (list2.contains(list1.get(0))) {
                    int index = list2.indexOf(list1.get(0));
                    union.add(list1.get(0));
                    intersection.add(list1.get(0));
                    list1.remove(0);
                    list2.remove(index);
                }
                else {
                    union.add(list1.get(0));
                    list1.remove(0);
                }
            }
            while (!list2.isEmpty()) {
                union.add(list2.get(0));
                list2.remove(0);
            }
        }
        else {
            while (!list2.isEmpty()) {
                if (list1.contains(list2.get(0))) {
                    int index = list1.indexOf(list2.get(0));
                    union.add(list2.get(0));
                    intersection.add(list2.get(0));
                    list1.remove(index);
                    list2.remove(0);
                }
                else {
                    union.add(list2.get(0));
                    list2.remove(0);
                }
            }
            while (!list1.isEmpty()) {
                union.add(list1.get(0));
                list1.remove(0);
            }
        }

        if (union.isEmpty() && intersection.isEmpty()) {
            return 65536;
        }
        if (union.size() == intersection.size()) {
            return 1 * 65536;
        }
        double result = (intersection.size() / (double)union.size());

        return (int)(result * 65536);
    }

    public static void main(String[] args) {
        System.out.println(solution("handshake", "shake hands"));
    }
}
