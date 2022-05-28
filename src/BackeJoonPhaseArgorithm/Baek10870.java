package BackeJoonPhaseArgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek10870 {
    static private int fibo(int num) {
        if (num <= 1)
            return num;
        else
            return fibo(num - 1) + fibo(num - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        System.out.println(fibo(num));
    }
}
