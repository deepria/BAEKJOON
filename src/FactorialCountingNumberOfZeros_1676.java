import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FactorialCountingNumberOfZeros_1676 {
    static long beforeTime = System.currentTimeMillis();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();

        BigInteger x = BigInteger.valueOf(n);

        String[] arr = factorial(n, x).toString().split("");

        int cnt = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].equals("0")) {
                cnt++;
            } else {
                break;
            }
        }

        bw.write(cnt + "");

        bw.flush();
        bw.close();

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);

    }

    public static BigInteger factorial(int n, BigInteger x) {

        if (n == 0) {
            return BigInteger.valueOf(1);
        }

        x = x.multiply(BigInteger.valueOf(n - 1));
        n--;

        if (n != 1) {
            return factorial(n, x);

        }

        return x;
    }

}