package divideAndConquer;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Z_1074 {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        int n = in.nextInt();
        int r = in.nextInt();
        int c = in.nextInt();
        System.out.println(rs((int) Math.pow(2, n), r, c, 0));

    }

    static int rs(int n, int r, int c, int start) {
        if (n == 1) {
            if (r == 0 && c == 0) {
                return start;
            }
        }
        int newStart;
        if (r < n / 2) {
            if (c < n / 2) {
                newStart = start;
            } else {
                newStart = start + (n / 2) * (n / 2);
                c -= n / 2;
            }
        } else {
            if (c < n / 2) {
                newStart = start + (n / 2) * (n / 2) * 2;
                r -= n / 2;
            } else {
                newStart = start + (n / 2) * (n / 2) * 3;
                c -= n / 2;
                r -= n / 2;
            }
        }
        return rs(n / 2, r, c, newStart);
    }
}