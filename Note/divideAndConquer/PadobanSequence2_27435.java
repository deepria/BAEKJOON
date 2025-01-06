package divideAndConquer;

import util.Reader;

public class PadobanSequence2_27435 {

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        int t = in.nextInt();
        StringBuilder sb = new StringBuilder();
        long[][] matrix = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 0 } };
        long[][] vector = { { 1 }, { 1 }, { 1 } };
        for (int cases = 0; cases < t; cases++) {
            long n = in.nextLong();
            long[][] temp = matrixMulti(metrixPow(n - 1, matrix), vector);
            sb.append(temp[0][0]).append("\n");
        }
        System.out.println(sb);
    }

    public static long[][] metrixPow(long power, long[][] matrix) {

        long[][] result = new long[3][3];

        for (int i = 0; i < 3; i++) {
            result[i][i] = 1;
        }

        while (power > 0) {
            if (power % 2 == 1) {
                result = matrixMulti(result, matrix);
            }
            matrix = matrixMulti(matrix, matrix);
            power /= 2;
        }

        return result;
    }

    public static long[][] matrixMulti(long[][] a, long[][] b) {
        long[][] temp = new long[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < 3; k++) {
                    temp[i][j] += (a[i][k] * b[k][j]);
                }
                temp[i][j] %= 998244353;
            }
        }
        return temp;
    }
}