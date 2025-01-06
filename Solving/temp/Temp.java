package temp;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Temp {
    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        int t = in.nextInt();
        StringBuilder sb = new StringBuilder();
        long[][] metrix = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 0 } };
        long[][] vector = { { 1 }, { 1 }, { 1 } };
        for (int cases = 0; cases < t; cases++) {
            int n = in.nextInt();
            long[][] temp = metrixMulti(metrixPow(n - 1, metrix), vector);
            sb.append(temp[0][0]).append("\n");
        }
        System.out.println(sb);
    }

    public static long[][] metrixPow(int n, long[][] metrix) {

        long[][] temp = metrix;
        while (n != 0) {
            if (n % 2 != 0) {
                temp = metrixMulti(temp, temp);
            }
            temp = metrixMulti(temp, metrix);
            n /= 2;
        }
        return temp;

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

    public static long[][] metrixMulti(long[][] a, long[][] b) {
        long[][] temp = new long[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < 3; k++) {
                    temp[i][j] += (a[i][k] * b[k][j]) % 998244353;
                }
            }
        }
        return temp;
    }
}

class Reader {
    final int SIZE = 1 << 13;
    byte[] buffer = new byte[SIZE];
    int index, size;

    public char nextChar() throws Exception {
        byte c;
        while ((c = read()) <= 32)
            ;
        return (char) c;
    }

    public int nextInt() throws Exception {
        int n = 0;
        byte c;
        boolean isMinus = false;
        while ((c = read()) <= 32)
            ;
        if (c == 45) {
            c = read();
            isMinus = true;
        }
        do
            n = (n << 3) + (n << 1) + (c & 15);
        while (isNumber(c = read()));
        return isMinus ? ~n + 1 : n;
    }

    public long nextLong() throws Exception {
        long n = 0;
        byte c;
        boolean isMinus = false;
        while ((c = read()) <= 32)
            ;
        if (c == 45) {
            c = read();
            isMinus = true;
        }
        do
            n = (n << 3) + (n << 1) + (c & 15);
        while (isNumber(c = read()));
        return isMinus ? ~n + 1 : n;
    }

    boolean isNumber(byte c) {
        return 47 < c && c < 58;
    }

    byte read() throws Exception {
        if (index == size) {
            size = System.in.read(buffer, index = 0, SIZE);
            if (size < 0)
                buffer[0] = -1;
        }
        return buffer[index++];
    }
}
