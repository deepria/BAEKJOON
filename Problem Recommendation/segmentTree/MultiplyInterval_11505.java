package segmentTree;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MultiplyInterval_11505 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(br.readLine());
        }
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int tree_size = (1 << (h + 1));
        long[] tree = new long[tree_size];
        init(a, tree, 1, 0, n - 1);

        int left;
        int right;
        int command;
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            command = Integer.parseInt(st.nextToken());
            left = Integer.parseInt(st.nextToken());
            right = Integer.parseInt(st.nextToken());
            if (command == 1) {
                update(a, tree, 1, 0, n - 1, left - 1, right);
            } else {
                bw.write(query(tree, 1, 0, n - 1, left - 1, right - 1) + "\n");
            }

        }

        bw.flush();
        bw.close();
    }

    static void init(long[] a, long[] tree, int node, int start, int end) {
        if (start == end) {
            tree[node] = a[start];
        } else {
            init(a, tree, node * 2, start, (start + end) / 2);
            init(a, tree, node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = tree[node * 2] * tree[node * 2 + 1] % 1000000007;
        }
    }

    static long query(long[] tree, int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 1;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        long lnode = query(tree, node * 2, start, (start + end) / 2, left, right);
        long rnode = query(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return lnode * rnode % 1000000007;
    }

    static void update(long[] a, long[] tree, int node, int start, int end, int index, long val) {
        if (index < start || index > end) {
            return;
        }
        if (start == end) {
            a[index] = val;
            tree[node] = val;
            return;
        }
        update(a, tree, node * 2, start, (start + end) / 2, index, val);
        update(a, tree, node * 2 + 1, (start + end) / 2 + 1, end, index, val);
        tree[node] = tree[node * 2] * tree[node * 2 + 1] % 1000000007;
    }

}
