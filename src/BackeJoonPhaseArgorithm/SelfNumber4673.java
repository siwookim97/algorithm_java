package BackeJoonPhaseArgorithm;

public class SelfNumber4673 {
    static int d(int number) {
        int n = number;
        while (number > 0) {
            n += (number % 10);
            number = number / 10;
        }
        return n;
    }

    public static void main(String[] args) {
        int index = 10000;
        boolean[] nums = new boolean[10000];

        for (int i = 0 ; i < nums.length; i++) {
            if (d(i + 1) < index + 1) {
                nums[d(i + 1) - 1] = true;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == false)
                System.out.println(i + 1);
        }
    }
}
