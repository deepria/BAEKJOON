package fs;

import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DFSAndBFS_1260 {

    static int[][] arr;
    static BitSet bs;
    static int node;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int n) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(n);

        while (!stack.isEmpty()) {

            n = stack.pop();
            System.out.println(n);
            if (!bs.get(n)) {
                bs.set(n);
                sb.append(n + " ");
                for (int i = node; i >= 1; i--) {
                    if (arr[n][i] == 1 && !bs.get(i)) {
                        if (!bs.get(i)) {
                            stack.push(i);
                        }
                    }
                }
            }

        }
    }

    public static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(n);
        bs.set(n);

        while (!queue.isEmpty()) {

            n = queue.poll();
            sb.append(n + " ");

            for (int i = 1; i <= node; i++) {
                if (arr[n][i] == 1 && !bs.get(i)) {
                    queue.add(i);
                    bs.set(i);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        node = in.nextInt();
        int line = in.nextInt();
        int start = in.nextInt();
        arr = new int[node + 1][node + 1];
        bs = new BitSet(node + 1);

        for (int i = 0; i < line; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            arr[a][b] = arr[b][a] = 1;
        }

        for (int i = 1; i < node + 1; i++) {
            for (int j = 1; j < node + 1; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        dfs(start);
        sb.append("\n");
        bs.clear();
        bfs(start);
        System.out.println(sb);

    }
}
