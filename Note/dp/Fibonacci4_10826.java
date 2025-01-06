package dp;

import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci4_10826 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        int n = in.nextInt();
        System.out.println(fib_dp(n));
    }

    static BigInteger fib_dp(int n) {
        BigInteger[] arr = new BigInteger[n + 1];
        arr[0] = new BigInteger("0");
        if (n > 0) {
            arr[1] = new BigInteger("1");
        }
        if (n > 1) {
            arr[2] = new BigInteger("1");
        }
        if (n > 2) {
            for (int i = 3; i <= n; i++) {
                arr[i] = arr[i - 1].add(arr[i - 2]);
            }
        }
        return arr[n];
    }
}