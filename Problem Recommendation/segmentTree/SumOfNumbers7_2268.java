package segmentTree;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SumOfNumbers7_2268 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 0;
        }
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int tree_size = (1 << (h + 1));
        long[] tree = new long[tree_size];
        init(arr, tree, 1, 0, n - 1);

        int command, left, jk;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            command = Integer.parseInt(st.nextToken());
            left = Integer.parseInt(st.nextToken());
            jk = Integer.parseInt(st.nextToken());
            if (command == 0) {
                bw.write(query(tree, 1, 0, n - 1, Math.min(left, jk) - 1, Math.max(left, jk) - 1) + "\n");
            } else {
                update(tree, 1, 0, n - 1, left - 1, jk);
            }

        }
        br.close();
        bw.flush();
        bw.close();
    }

    static void init(int[] a, long[] tree, int node, int start, int end) {
        if (start == end) {
            tree[node] = a[start];
        } else {
            init(a, tree, node * 2, start, (start + end) / 2);
            init(a, tree, node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    static long query(long[] tree, int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        long lnode = query(tree, node * 2, start, (start + end) / 2, left, right);
        long rnode = query(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return lnode + rnode;
    }

    static void update(long[] tree, int node, int start, int end, int index, int val) {
        if (index < start || index > end) {
            return;
        }
        if (start == end) {
            tree[node] = val;
            return;
        }
        update(tree, node * 2, start, (start + end) / 2, index, val);
        update(tree, node * 2 + 1, (start + end) / 2 + 1, end, index, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

}