package divideAndConquer;

import util.Reader;

public class MakingColoredPaper_2630 {

    static int[][] arr;
    static int n, blue = 0, white = 0;

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        n = in.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        recur(n, 0, 0);
        System.out.println(white + "\n" + blue);

    }

    public static void recur(int n, int r, int c) {
        if (n == 0) {
            return;
        }

        int temp = arr[r][c];
        boolean is = true;
        for (int i = r; i < n + r; i++) {
            for (int j = c; j < n + c; j++) {
                if (temp == arr[i][j]) {
                    continue;
                } else {
                    is = false;
                    break;
                }
            }
        }

        if (is) {
            if (temp == 0) {
                white++;
            } else {
                blue++;
            }
        } else {
            recur(n / 2, r, c);
            recur(n / 2, r + n / 2, c);
            recur(n / 2, r, c + n / 2);
            recur(n / 2, r + n / 2, c + n / 2);
        }

    }
}