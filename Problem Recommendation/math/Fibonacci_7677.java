package math;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Fibonacci_7677 {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = in.nextInt();
        while (n != -1) {
            if (n == 0) {
                sb.append(0 + "\n");
            } else {
                long[][] ans = recur(n);
                sb.append(ans[0][1] + "\n");
            }
            n = in.nextInt();
        }
        System.out.println(sb);

    }

    public static long[][] base = new long[][] { { 1, 1 }, { 1, 0 } };

    public static long[][] recur(long n) {
        long[][] temp = null;
        if (n == 1)
            return base;
        if (n % 2 == 0) {
            temp = recur(n / 2);
            return multiply(temp, temp);
        } else {
            temp = recur((n - 1) / 2);
            return multiply(base, multiply(temp, temp));
        }
    }

    public static long div = 10000;

    public static long[][] multiply(long[][] a, long[][] b) {
        long[][] answer = new long[2][2];

        answer[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % div;
        answer[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % div;
        answer[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % div;
        answer[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % div;

        return answer;
    }

}
