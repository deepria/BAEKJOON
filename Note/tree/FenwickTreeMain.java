package tree;

class FenwickTree {
    final int SIZE;
    long[] tree;

    public FenwickTree(int size) {
        SIZE = size;
        tree = new long[SIZE];
    }

    public void update(int idx, long value) {
        while (idx < SIZE) {
            tree[idx] += value;
            idx += (idx & -idx);
        }
    }

    public long sum(int idx) {
        long sum = 0;

        while (idx > 0) {
            sum += tree[idx];
            idx -= (idx & -idx);
        }

        return sum;
    }
}

public class FenwickTreeMain {
    public static void main(String[] argu) throws Exception {
        Reader in = new Reader();
        final int MAX = 1000001;

        int n = in.nextInt();
        int[] A = new int[n + 1];
        int[] idxA = new int[MAX];
        int[] to = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            A[i] = in.nextInt();
            idxA[A[i]] = i;
        }

        for (int i = 1; i <= n; i++) {
            int t = in.nextInt();
            to[idxA[t]] = i;
        }

        FenwickTree fwTree = new FenwickTree(n + 1);
        long inversionCounting = 0;

        for (int i = n; i > 0; i--) {
            inversionCounting += fwTree.sum(to[idxA[A[i]]] - 1);
            fwTree.update(to[idxA[A[i]]], 1L);
        }

        System.out.print(inversionCounting);
    }
}

class Reader {
    final int SIZE = 1 << 13;
    byte[] buffer = new byte[SIZE];
    int index, size;

    char nextChar() throws Exception {
        byte c;
        while ((c = read()) <= 32)
            ;
        return (char) c;
    }

    int nextInt() throws Exception {
        int n = 0;
        byte c;
        boolean isMinus = false;
        while ((c = read()) <= 32) // { if (size < 0) return -1; }
            if (c == 45) {
                c = read();
                isMinus = true;
            }
        do
            n = (n << 3) + (n << 1) + (c & 15);
        while (isNumber(c = read()));
        return isMinus ? ~n + 1 : n;
    }

    long nextLong() throws Exception {
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