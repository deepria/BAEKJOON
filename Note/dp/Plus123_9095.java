package dp;

import util.Reader;

public class Plus123_9095 {

    static int[] dp = new int[11];

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        StringBuilder sb = new StringBuilder();
        dp();
        int t = in.nextInt();
        for (int cases = 0; cases < t; cases++) {
            int n = in.nextInt();
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }

    static void dp() {
        dp[0] = 1;
        for (int i = 0; i < 11; i++) {
            if (i - 1 >= 0) {
                dp[i] += dp[i - 1];
            }
            if (i - 2 >= 0) {
                dp[i] += dp[i - 2];
            }
            if (i - 3 >= 0) {
                dp[i] += dp[i - 3];
            }
        }

    }

}