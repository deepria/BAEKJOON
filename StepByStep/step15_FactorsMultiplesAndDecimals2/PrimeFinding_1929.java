package step15_FactorsMultiplesAndDecimals2;
import java.io.*;
import java.util.*;

public class PrimeFinding_1929 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] prime = new int[n + 1];

        for (int i = 0; i < prime.length; i++) {
            prime[i] = i;
        }
        prime[0] = 0;
        prime[1] = 0;
        if (prime.length > 4) {
            prime[4] = 0;
        }

        for (int i = 2; i * i < n; i++) {

            if (prime[i] != 0) {

                for (int j = i * i; j <= n; j += i) {
                    prime[j] = 0;
                }
            }
        }

        for (int i = 0; i < prime.length; i++) {
            if (prime[i] != 0 && prime[i] >= m) {

                bw.write(prime[i] + "\n");
            }
        }

        bw.flush();
    }
}