package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek4796 {
    public static void cal(ArrayList<HashMap<String, Integer>> list) {
        int cnt, L, P, V;

        for (int i = 0; i < list.size(); i++) {
            L = list.get(i).get("L");
            P = list.get(i).get("P");
            V = list.get(i).get("V");

            if (L == 0 && P == 0 && V == 0) {
                return ;
            }
            else {
                cnt = (V / P) * L + Math.min((V % P), L);
                System.out.println("Case " + (i+1) + ": " + cnt);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<HashMap<String, Integer>> list = new ArrayList<>();
        HashMap<String, Integer> map;
        Integer L, P, V;

        do {
            map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            map.put("L", L);
            map.put("P", P);
            map.put("V", V);
            list.add(map);
        } while (L != 0 && P != 0 && V != 0);

        cal(list);
    }
}
