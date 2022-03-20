package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        double r = Integer.parseInt(br.readLine());

        double uc = Math.PI * r * r;
        double tc = r * r * 2;

        System.out.printf("%.6f \n", uc);
        System.out.printf("%.6f \n", tc);
    }
}
