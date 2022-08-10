package Programmers_Lev1;

public class Code67256 {
    public static String solution(int[] numbers, String hand) {
        String str = "";
        int[] handArr = {3, 0, 3, 2}; // 왼손 / 오른손 좌표
        int rightAbs = 0;
        int leftAbs = 0;
        for (int i = 0; i < numbers.length; i++) {
            if ((numbers[i] - 1) % 3 == 2) {
                handArr[2] = (numbers[i] - 1) / 3;
                handArr[3] = (numbers[i] - 1) % 3;
                str += 'R';
            }
            else if ((numbers[i] - 1) % 3 == 0) {
                handArr[0] = (numbers[i] - 1) / 3;
                handArr[1] = (numbers[i] - 1) % 3;
                str += 'L';
            }
            else if ((numbers[i] - 1) % 3 == 1 && numbers[i] != 0){
                leftAbs = Math.abs((numbers[i] - 1) / 3 - handArr[0]) + Math.abs((numbers[i] - 1) % 3 - handArr[1]);
                rightAbs = Math.abs((numbers[i] - 1) / 3 - handArr[2]) + Math.abs((numbers[i] - 1) % 3 - handArr[3]);
                if (leftAbs == rightAbs) {
                    if (hand.equals("right")) {
                        handArr[2] = (numbers[i] - 1) / 3;
                        handArr[3] = (numbers[i] - 1) % 3;
                        str += 'R';
                    }
                    else {
                        handArr[0] = (numbers[i] - 1) / 3;
                        handArr[1] = (numbers[i] - 1) % 3;
                        str += 'L';
                    }
                }
                else if (leftAbs > rightAbs) {
                    handArr[2] = (numbers[i] - 1) / 3;
                    handArr[3] = (numbers[i] - 1) % 3;
                    str += 'R';
                }
                else {
                    handArr[0] = (numbers[i] - 1) / 3;
                    handArr[1] = (numbers[i] - 1) % 3;
                    str += 'L';
                }
            }
            else { // 0일 때에
                leftAbs = Math.abs(3 - handArr[0]) + Math.abs(1 - handArr[1]);
                rightAbs = Math.abs(3 - handArr[2]) + Math.abs(1 - handArr[3]);
                if (leftAbs == rightAbs) {
                    if (hand.equals("right")) {
                        handArr[2] = 3;
                        handArr[3] = 1;
                        str += 'R';
                    }
                    else {
                        handArr[0] = 3;
                        handArr[1] = 1;
                        str += 'L';
                    }
                }
                else if (leftAbs > rightAbs) {
                    handArr[2] = 3;
                    handArr[3] = 1;
                    str += 'R';
                }
                else {
                    handArr[0] = 3;
                    handArr[1] = 1;
                    str += 'L';
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(solution( new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    }
}
