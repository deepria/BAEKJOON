package fs.dfs;

import java.util.BitSet;
import java.util.Stack;

public class NumberOfConnectionElements_11724 {

    static BitSet bs;
    static int vertex;
    static BitSet[] adjMat;

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        vertex = in.nextInt();
        int edge = in.nextInt();
        bs = new BitSet(vertex + 1);
        adjMat = new BitSet[vertex + 1];
        for (int i = 1; i <= vertex; i++) {
            adjMat[i] = new BitSet(vertex + 1);
        }
        for (int i = 0; i < edge; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            adjMat[a].set(b);
            adjMat[b].set(a);
        }

        int cnt = 0;
        for (int i = 1; i <= vertex; i++) {
            cnt = dfs(i) ? cnt + 1 : cnt;
        }

        System.out.println(cnt);
    }

    static boolean dfs(int node) {
        boolean is = false;
        int ec = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(node);
        bs.set(node);

        while (!stack.isEmpty()) {
            node = stack.pop();

            for (int i = 1; i <= vertex; i++) {
                if (!bs.get(i) && adjMat[node].get(i)) {
                    stack.push(i);
                    bs.set(i);
                    is = true;
                }
                if (!adjMat[node].get(i)) {
                    ec++;
                }
            }
        }
        is = ec == vertex ? true : is;
        return is;
    }

}

class Reader {
    final int SIZE = 1 << 13;
    byte[] buffer = new byte[SIZE];
    int index, size;

    public int nextInt() throws Exception {
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