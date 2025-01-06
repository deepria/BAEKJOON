package dp;

import java.io.InputStreamReader;
import java.util.Scanner;

public class BABBA_9625 {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        int k = in.nextInt();
        int[][] dp = new int[k + 2][2];
        dp[1][0] = 1;
        dp[1][1] = 0;
        for (int i = 2; i <= k + 1; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }

        System.out.println(dp[k + 1][0] + " " + dp[k + 1][1]);
    }

}
