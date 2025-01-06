package fs.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import util.Tuple;

public class MazeNavigation_2178 {
    static int[] dr = new int[] { 0, 1, -1, 0 };
    static int[] dc = new int[] { 1, 0, 0, -1 };
    static int[][] arr;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("[%-2d]", arr[i][j]);
            }
            System.out.println();
        }

        System.out.println(arr[n - 1][m - 1]);

    }

    static void bfs() {
        Queue<Tuple> q = new LinkedList();
        q.add(Tuple.of(0, 0));
        while (!q.isEmpty()) {
            Tuple<Integer, Integer> tuple = q.poll();
            for (int d = 0; d < 4; d++) {
                int i = tuple.getA() + dr[d];
                int j = tuple.getB() + dc[d];
                if (i >= 0 && i < n && j >= 0 && j < m && arr[i][j] == 1) {
                    arr[i][j] += arr[tuple.getA()][tuple.getB()];
                    q.add(Tuple.of(i, j));
                }
            }
        }
    }
}