package dp;

import util.Reader;

public class WhatIsDynamic_14494 {

    static long[][] dp;

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        int n = in.nextInt();
        int m = in.nextInt();
        dp = new long[n + 1][m + 1];
        dp(n, m);
        System.out.println(dp[n][m]);
    }

    static void dp(int n, int m) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 || j == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1] + dp[i - 1][j - 1]) % 1000000007;
                }
            }
        }
    }
}