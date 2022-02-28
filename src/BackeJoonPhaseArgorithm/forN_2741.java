package BackeJoonPhaseArgorithm;

import java.io.*;
import java.util.*;

public class forN_2741 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());

        for(int i = 1; i <= length; i++)
        {
            bw.write(i + "\n");
        }
        // 값 출력
        bw.flush();
        bw.close();
        br.close();
    }
}
