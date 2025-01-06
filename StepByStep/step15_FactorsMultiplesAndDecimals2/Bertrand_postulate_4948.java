package step15_FactorsMultiplesAndDecimals2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bertrand_postulate_4948 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while (n != 0) {

            int n2 = n * 2;

            int[] prime = new int[n2 + 1];

            for (int i = 0; i < prime.length; i++) {
                prime[i] = i;
            }
            prime[0] = 0;
            if (prime.length > 1) {
                prime[1] = 0;
            }
            if (prime.length > 4) {
                prime[4] = 0;
            }

            for (int i = 2; i * i < n2; i++) {

                if (prime[i] != 0) {

                    for (int j = i * i; j <= n2; j += i) {
                        prime[j] = 0;
                    }
                }
            }
            int cnt = 0;
            for (int i = 0; i < prime.length; i++) {
                if (prime[i] != 0 && prime[i] > n) {
                    cnt++;
                }
            }

            sb.append(cnt + "\n");

            n = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);
        br.close();

    }
}