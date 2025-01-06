package step15_FactorsMultiplesAndDecimals2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GoldbachPartition_17103 {
    public static boolean prime[];
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        arr = new int[t];
        int max = 0;

        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = arr[i] > max ? arr[i] : max;
        }
        br.close();
        make_prime(max);
        partition();
        for (int i : arr) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void make_prime(int max) {
        prime = new boolean[max + 1];
        if (max < 2) {
            return;
        }
        prime[0] = prime[1] = true;
        for (int i = 2; i * i <= max; i++) {
            if (prime[i] == true) {
                continue;
            }
            for (int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }
    }

    public static void partition() {
        int cnt;
        for (int i = 0; i < arr.length; i++) {
            cnt = 0;
            for (int j = 2; j <= arr[i] / 2; j++) {
                if (!prime[j]) {
                    cnt = !prime[arr[i] - j] ? cnt + 1 : cnt;
                }
            }
            arr[i] = cnt;
        }
    }
}