package dp;

import java.io.InputStreamReader;
import java.util.Scanner;

public class TwoTimesNTiling2_11727 {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        int n = in.nextInt();
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 3;
        }
        if (n > 2) {
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
            }
        }
        System.out.println(dp[n]);
    }
}