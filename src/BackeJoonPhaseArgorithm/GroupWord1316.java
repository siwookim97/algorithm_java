package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroupWord1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        boolean sig = true;

        int[] arr = new int[26];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 27;
        }

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            arr[str.charAt(0) - 97] = 0;
            for (int j = 1; j < str.length(); j++) {
                int ch = str.charAt(j);

                if (arr[ch - 97] == j - 1)
                    arr[ch - 97] = j;  // 앞과 같으면 갱신
                else {
                    if (arr[ch - 97] != 27) {
                        sig = false;
                        break;
                    }
                    else {
                        arr[ch - 97] = j;
                    }
                }
            }
            if (sig == true) {
                cnt++;
            }
            sig = true;

            for (int h = 0; h < arr.length; h++) {
                arr[h] = 27;
            }
        }

        System.out.println(cnt);
    }
}
