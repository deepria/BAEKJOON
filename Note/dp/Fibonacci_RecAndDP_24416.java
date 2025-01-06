package dp;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Fibonacci_RecAndDP_24416 {

    static int rec = 1;
    static int dp = 0;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        int n = in.nextInt();
        fib_rec(n);
        fib_dp(n);
        System.out.println(rec + " " + dp);
    }

    static int fib_rec(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            rec++;
            return (fib_rec(n - 1) + fib_rec(n - 2));
        }
    }

    static int fib_dp(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp++;
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
