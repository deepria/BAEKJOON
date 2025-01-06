package segmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Factory_7578 {
    static long[] tree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] firstLine = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            firstLine[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, Integer> secondLine = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            secondLine.put(Integer.parseInt(st.nextToken()), i);
        }
        br.close();
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int tree_size = (1 << (h + 1));
        tree = new long[tree_size];
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int valB = secondLine.get(firstLine[i]);
            ans += query(1, n, 1, valB + 1, n);
            update(1, n, 1, valB, 1);
        }
        System.out.println(ans);
    }

    public static long query(int start, int end, int node, int left, int right) {
        if (end < left || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return query(start, mid, node * 2, left, right) + query(mid + 1, end, node * 2 + 1, left, right);
    }

    public static void update(int start, int end, int node, int idx, int dif) {
        if (idx < start || idx > end) {
            return;
        }
        tree[node] += dif;
        if (start != end) {
            int mid = (start + end) / 2;
            update(start, mid, node * 2, idx, dif);
            update(mid + 1, end, node * 2 + 1, idx, dif);
        }
    }
}
