package math;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class BacteriaSmall_12445 {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Reader in = new Reader();
        int t = in.nextInt();

        int a, b, c;
        for (int i = 1; i <= t; i++) {
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            int answer;
            if (b == 1) {
                answer = pow(a, a, c);
            } else {
                int base = pow(a, a, c);

                if (base == 0) {
                    answer = 0;
                } else {
                    int power = pow(a, a, phi(c));
                    if (power == 0) {
                        power += phi(c);
                    }
                    answer = pow(base, power, c);
                }
            }

            bw.write("Case #" + i + ": " + answer + "\n");

        }
        bw.flush();
        bw.close();
    }

    public static int phi(int x) {

        int result = x;

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                while (x % i == 0) {
                    x /= i;
                }
                result -= result / i;
            }
        }
        if (x > 1) {
            result -= result / x;
        }

        return result;
    }

    public static int pow(int x, int n, int mod) {

        int result = 1;

        while (n != 0) {
            if (n % 2 != 0) {
                result = (result * x) % mod;
            }
            x = (x * x) % mod;
            n /= 2;
        }

        return result;
    }
}
