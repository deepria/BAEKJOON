package dp;

import java.io.InputStreamReader;
import java.util.Scanner;

public class RecurrenceRelation_13699 {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        int n = in.nextInt();
        long[] dp = new long[n + 1];

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int a = 0;
            int b = i - 1;
            while (b != -1) {
                dp[i] += dp[a] * dp[b];
                a++;
                b--;
            }
        }

        System.out.println(dp[n]);

    }
}