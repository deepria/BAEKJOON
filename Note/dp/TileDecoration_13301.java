package dp;

import java.io.InputStreamReader;
import java.util.Scanner;

public class TileDecoration_13301 {

    static long[] dp;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        int n = in.nextInt();
        dp = new long[n + 1];
        fib_dp(n);
        if (n == 1) {
            System.out.println(4);
        } else if (n == 2) {
            System.out.println(6);
        } else if (n == 3) {
            System.out.println(10);
        } else {
            System.out.println(dp[n] * 3 + dp[n - 1] * 2 + dp[n - 2] * 2 + dp[n - 3]);
        }
    }

    static void fib_dp(int n) {

        dp[0] = 0;
        if (n > 0) {
            dp[1] = 1;
        }
        if (n > 1) {
            dp[2] = 1;
        }
        if (n > 2) {
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
    }
}
