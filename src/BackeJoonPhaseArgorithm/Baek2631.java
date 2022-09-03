package BackeJoonPhaseArgorithm;

import java.util.Scanner;

public class Baek2631 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, n=sc.nextInt(), max = 0, a[] = new int[n+1], d[] = new int[n+1];

        for(i = 1; i <= n; i++)
            a[i] = sc.nextInt();

        for(i = 1; i <= n; i++){
            d[i] = 1;
            for(j = 1; j < i; j++)
                if(a[j] < a[i] && d[i] < d[j] + 1)
                    d[i]++;
            if(max < d[i]) max = d[i];
        }
        System.out.println(n - max);
        sc.close();
    }

}