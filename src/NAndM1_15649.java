import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class NAndM1_15649 {
    static long beforeTime = System.currentTimeMillis();

    public static boolean[] visit;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        br.close();

        visit = new boolean[n];
        arr = new int[m];

        dfs(n, m, 0);
        bw.write(sb + "");

        long afterTime = System.currentTimeMillis();
        float secDiffTime = (afterTime - beforeTime);

        // bw.write(secDiffTime / 1000 + "s");

        bw.flush();
        bw.close();

    }

    public static void dfs(int n, int m, int depth) {

        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(n, m, depth + 1);

                visit[i] = false;
            }

        }

    }

}