package Chapter03;

import javax.xml.crypto.dsig.keyinfo.PGPData;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearch {
    static class PhyscData {
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString() {
            return name + " " + height + " " + vision;
        }

        public static final Comparator<PhyscData> VISION_ORDER = new VisionOrderComparator();

        private static class VisionOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData d1, PhyscData d2) {
                return (d1.vision > d2.vision) ? 1 : (d1.vision == d2.vision) ? 0 : -1;
            }
        }

    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        PhyscData[] x = {
                new PhyscData("이나령", 162, 0.3),
                new PhyscData("유지훈", 168, 0.4),
                new PhyscData("김한결", 169, 0.7),
                new PhyscData("홍준기", 171, 0.8),
                new PhyscData("전서현", 173, 1.2),
                new PhyscData("이호연", 174, 1.5),
                new PhyscData("이수민", 175, 2.0),
        };
        System.out.print("시력이 몇인 사람을 찾고 있나요? : ");
        double vision = stdIn.nextDouble();
        int idx = Arrays.binarySearch(
                x,
                new PhyscData("", 0, vision),
                PhyscData.VISION_ORDER);

        if (idx < 0) System.out.println("찾고자 하는 값이 없습니다.");
        else {
            System.out.println("찾고자 하는 사람의 정보는 x[" + idx + "]에 있습니다.");
            System.out.println("x[" + idx + "]의 정보는 " + x[idx] + "입니다.");
        }
    }

}
