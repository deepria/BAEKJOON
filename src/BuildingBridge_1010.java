import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.io.IOException;
import java.util.StringTokenizer;

public class BuildingBridge_1010 {
    static int[][] dp;
    static long beforeTime = System.currentTimeMillis();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < t; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            dp = new int[m + 1][n + 1];

            bw.write(bc(m, n) + "\n");

        }

        br.close();

        bw.flush();
        bw.close();

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);

    }

    public static int bc(int n, int k) {

        if (dp[n][k] > 0) {
            return dp[n][k];
        }

        if (k == 0 || n == k) {
            return dp[n][k] = 1;
        }

        return dp[n][k] = (bc(n - 1, k - 1) + bc(n - 1, k));
    }

}