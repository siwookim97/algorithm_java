import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek16953 {
    public static int cal(int A, int B) {
        int cnt = 1;
        while (A < B) {
            if (B % 10 == 1) {
                B = (B - 1) / 10;
                cnt++;
            } else if (B % 2 == 0) {
                B = B / 2;
                cnt++;
            } else {
                return -1;
            }
        }
        if (A == B)
            return cnt;
        else
            return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " " );

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(cal(A, B));
    }
}
