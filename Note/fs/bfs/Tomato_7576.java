package fs.bfs;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

import util.Reader;

public class Tomato_7576 {

    static int col, row, days;
    static int[][] arr;
    static boolean allRipen = true, wailingWall = false, uShallNotPass = false;
    static int[] dr = new int[] { -1, 0, 1, 0 };
    static int[] dc = new int[] { 0, 1, 0, -1 };

    public static void bfs() {
        days = 0;
        Queue<Tuple> q = new LinkedList<Tuple>();
        BitSet[] bs = new BitSet[row + 2];
        for (int i = 0; i < bs.length; i++) {
            bs[i] = new BitSet(col + 2);
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (arr[i][j] != 1) {
                    continue;
                } else {
                    q.add(Tuple.of(i, j, 0));
                    bs[i].set(j);
                }
            }
        }
        while (!q.isEmpty()) {
            Tuple node = q.poll();
            days = node.getC() > days ? node.getC() : days;

            for (int d = 0; d < 4; d++) {
                int temp_i = node.getA() + dr[d];
                int temp_j = node.getB() + dc[d];
                if (arr[temp_i][temp_j] == -1 || bs[temp_i].get(temp_j)) {
                    continue;
                } else {
                    q.add(Tuple.of(temp_i, temp_j, node.getC() + 1));
                    bs[temp_i].set(temp_j);
                }
            }

        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (bs[i].get(j) || arr[i][j] != 0) {
                    continue;
                } else {
                    uShallNotPass = true;
                }
            }
        }
    }

    public static void IsThisWorthRunningBFS() {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (arr[i][j] == 1 || arr[i][j] == -1) {
                    continue;
                } else {
                    if (arr[i - 1][j] == -1 && arr[i][j - 1] == -1 && arr[i + 1][j] == -1 && arr[i][j + 1] == -1) {
                        wailingWall = true;
                    }
                    allRipen = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        col = in.nextInt();
        row = in.nextInt();
        arr = new int[row + 2][col + 2];

        for (int i = 0; i <= row + 1; i++) {
            for (int j = 0; j <= col + 1; j++) {
                if (i == 0 || j == 0 || i == row + 1 || j == col + 1) {
                    arr[i][j] = -1;
                } else {
                    arr[i][j] = in.nextInt();
                }
            }
        }

        IsThisWorthRunningBFS();

        if (allRipen) {
            System.out.println(0);
        } else if (wailingWall) {
            System.out.println(-1);
        } else {
            bfs();
            if (uShallNotPass) {
                System.out.println(-1);
            } else {
                System.out.println(days);
            }
        }
    }

    public static class Tuple {

        private final int a;
        private final int b;
        private final int c;

        public Tuple(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public static Tuple of(final int a, final int b, final int c) {
            return new Tuple(a, b, c);
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public int getC() {
            return c;
        }

    }
}