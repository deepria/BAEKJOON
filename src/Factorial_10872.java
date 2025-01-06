import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

import javax.security.auth.x500.X500Principal;

public class Factorial_10872 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int x = n;

        bw.write(factorial(n, x) + "");

        bw.flush();
        bw.close();

    }

    public static int factorial(int n, int x) {

        if (n == 0) {
            return 1;
        }

        x = x * (n - 1);
        n--;

        if (n != 1) {
            return factorial(n, x);

        }

        return x;
    }

}
