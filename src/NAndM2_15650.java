import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class NAndM2_15650 {
    // static long beforeTime = System.currentTimeMillis();

    public static int n, m;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        br.close();

        arr = new int[m];

        dfs(1, 0);
        bw.write(sb + "");

        /*
         * long afterTime = System.currentTimeMillis();
         * float secDiffTime = (afterTime - beforeTime);
         * 
         * bw.write(secDiffTime / 1000 + "s");
         */
        bw.flush();
        bw.close();

    }

    public static void dfs(int at, int depth) {

        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i <= n; i++) {

            arr[depth] = i;
            dfs(i + 1, depth + 1);

        }
    }
}