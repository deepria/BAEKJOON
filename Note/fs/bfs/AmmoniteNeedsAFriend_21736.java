package fs.bfs;

import java.util.LinkedList;
import java.util.Queue;

import util.IntegerTuple;
import util.Reader;

public class AmmoniteNeedsAFriend_21736 {

    static int[] dr = new int[] { -1, 0, 1, 0 };
    static int[] dc = new int[] { 0, 1, 0, -1 };
    static int[][] arr;
    static int n, m, herePersonExist;

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n][m];
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char input = in.nextChar();
                if (input == 'I') {
                    x = i;
                    y = j;
                }
                arr[i][j] = input == 'O' ? 1 : input == 'X' ? 0 : input == 'I' ? 1 : 2;
            }
        }
        herePersonExist = 0;
        bfs(x, y);
        System.out.println(herePersonExist > 0 ? herePersonExist : "TT");
    }

    static void bfs(int x, int y) {
        Queue<IntegerTuple> q = new LinkedList<IntegerTuple>();
        q.add(IntegerTuple.of(x, y));
        while (!q.isEmpty()) {
            IntegerTuple tuple = q.poll();
            for (int d = 0; d < 4; d++) {
                int i = tuple.getA() + dr[d];
                int j = tuple.getB() + dc[d];
                if (i >= 0 && i < n && j >= 0 && j < m && arr[i][j] != 0) {
                    if (arr[i][j] == 2) {
                        herePersonExist++;
                    }
                    arr[i][j] = 0;
                    q.add(IntegerTuple.of(i, j));
                }
            }
        }
    }
}