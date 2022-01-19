package Chapter06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhyscExamSort {
    static class PhyscData {
        String name;
        int height;
        double vision;

        PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString() {
            return name + " " + height + " " + vision;
        }

        static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData d1, PhyscData d2) {
                return (d1.height > d2.height) ? -1 : (d1.height < d2.height) ? 1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        PhyscData[] x = {
                new PhyscData("김시우", 162, 0.3),
                new PhyscData("나시우", 173, 0.7),
                new PhyscData("다시우", 175, 2.0),
                new PhyscData("라시우", 171, 1.5),
                new PhyscData("마시우", 168, 0.4),
                new PhyscData("바시우", 174, 1.2),
                new PhyscData("사시우", 169, 0.8),
        };

        Arrays.sort(x, PhyscData.HEIGHT_ORDER);

        System.out.println("신체검사 리스트");
        System.out.println(" 이름        키       시력");
        System.out.println("--------------------------");
        for (int i = 0; i < x.length; i++)
            System.out.printf("%-9s%3d     %5.1f\n", x[i].name, x[i].height, x[i].vision);
    }
}
