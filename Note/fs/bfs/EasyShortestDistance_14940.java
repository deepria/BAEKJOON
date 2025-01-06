package fs.bfs;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

import util.Reader;

public class EasyShortestDistance_14940 {

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int row = in.nextInt();
        int col = in.nextInt();
        int[][] arr = new int[row][col];
        int[] dr = new int[] { -1, 0, 1, 0 };
        int[] dc = new int[] { 0, 1, 0, -1 };
        Tuple target = null;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = in.nextInt();
                if (arr[i][j] == 2) {
                    target = Tuple.of(i, j);
                }
            }
        }
        Queue<Tuple> q = new LinkedList<Tuple>();
        BitSet[] bs = new BitSet[row];
        for (int i = 0; i < row; i++) {
            bs[i] = new BitSet(col);
        }
        q.add(target);
        bs[target.getA()].set(target.getB());
        arr[target.getA()][target.getB()] = 0;

        while (!q.isEmpty()) {
            Tuple node = q.poll();

            for (int d = 0; d < 4; d++) {
                int temp_i = node.getA() + dr[d];
                int temp_j = node.getB() + dc[d];
                if (temp_i < 0 || temp_j < 0 || temp_i > row - 1 || temp_j > col - 1 || arr[temp_i][temp_j] == 0
                        || bs[temp_i].get(temp_j)) {
                    continue;
                } else {
                    q.add(Tuple.of(temp_i, temp_j));
                    bs[temp_i].set(temp_j);
                    arr[temp_i][temp_j] = arr[node.getA()][node.getB()] + 1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!bs[i].get(j) && arr[i][j] != 0) {
                    arr[i][j] = -1;
                }
            }
        }

        for (int[] is : arr) {
            for (int i : is) {
                bw.write(i + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}

class Tuple {

    private final int a;
    private final int b;

    public Tuple(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public static Tuple of(final int a, final int b) {
        return new Tuple(a, b);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

}