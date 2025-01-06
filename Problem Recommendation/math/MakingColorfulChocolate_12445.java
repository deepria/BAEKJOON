package math;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class MakingColorfulChocolate_12445 {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Reader in = new Reader();
        int t = in.nextInt();
        long[] arr = new long[81650001];
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            // arr[i] 는 각층의 민초 갯수의 누적합, 즉 순서
            arr[i] = (3 * (long) Math.pow(i, 2) + 5 * i + 2) / 2;

        }

        long n, fmint, answer = 0, idx;
        int floor, ft;
        for (int i = 0; i < t; i++) {
            n = in.nextLong();
            floor = binarySearch(arr, n);
            ft = floor - 1;
            fmint = (9 * (long) Math.pow(floor, 2) - 3 * floor - 4) / 2;
            idx = n - arr[floor - 1];
            if (idx == 0) {
                answer = fmint;
            }
            if (idx == 1) {
                answer = fmint + 4;
            }
            if (idx > 1 && idx < 2 + ft) {
                answer = fmint + 4 + 3 * (idx - 1);
            }
            if (idx == ft + 2) {
                answer = fmint + 4 + 3 * ft + 2;
            }
            if (idx > ft + 2) {
                answer = fmint + 4 + 3 * ft + 2 + 3 * (idx - 2 - ft);
            }
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static int binarySearch(long[] arr, long target) {
        int left = 1;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long midValue = arr[mid];
            long temp = arr[mid - 1];
            if (midValue >= target && temp <= target) {
                return mid;
            }
            if (midValue > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
