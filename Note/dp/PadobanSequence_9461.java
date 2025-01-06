package dp;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import util.Reader;

public class PadobanSequence_9461 {
    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = in.nextInt();
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for (int i = 6; i <= 100; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }
        for (int i = 0; i < t; i++) {
            bw.write(dp[in.nextInt()] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
