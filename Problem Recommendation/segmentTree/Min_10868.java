package segmentTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Min_10868 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(br.readLine());
        }
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int tree_size = (1 << (h + 1));
        long[] mintree = new long[tree_size];
        mininit(a, mintree, 1, 0, n - 1);

        int left;
        int right;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            left = Integer.parseInt(st.nextToken());
            right = Integer.parseInt(st.nextToken());
            bw.write(minquery(mintree, 1, 0, n - 1, left - 1, right - 1) + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void mininit(long[] a, long[] tree, int node, int start, int end) {
        if (start == end) {
            tree[node] = a[start];
        } else {
            mininit(a, tree, node * 2, start, (start + end) / 2);
            mininit(a, tree, node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
        }
    }

    static long minquery(long[] tree, int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return -1;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        long lmin = minquery(tree, node * 2, start, (start + end) / 2, left, right);
        long rmin = minquery(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        if (lmin == -1) {
            return rmin;
        } else if (rmin == -1) {
            return lmin;
        } else {
            return Math.min(lmin, rmin);
        }
    }

}
