import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.io.IOException;
import java.util.StringTokenizer;

public class BinomialCoefficient2_11051 {
    static int[][] dp;
    public static final int div = 10007;
    static long beforeTime = System.currentTimeMillis();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        br.close();

        dp = new int[n + 1][k + 1];

        bw.write(bc(n, k) + "");

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);

        // bw.write("\n" + secDiffTime + "ms");

        bw.flush();
        bw.close();

    }

    public static int bc(int n, int k) {

        if (dp[n][k] > 0) {
            return dp[n][k];
        }

        if (k == 0 || n == k) {
            return dp[n][k] = 1;
        }

        return dp[n][k] = (bc(n - 1, k - 1) + bc(n - 1, k)) % div;
    }

}