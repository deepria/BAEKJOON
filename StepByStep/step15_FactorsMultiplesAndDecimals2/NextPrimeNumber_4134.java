package step15_FactorsMultiplesAndDecimals2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NextPrimeNumber_4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        long n;

        for (int i = 0; i < t; i++) {
            n = Long.parseLong(br.readLine());

            while (!checker(n)) {
                n++;
            }
            bw.write(n + "\n");

        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean checker(long a) {
        if (a < 2)
            return false;
        for (long i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}