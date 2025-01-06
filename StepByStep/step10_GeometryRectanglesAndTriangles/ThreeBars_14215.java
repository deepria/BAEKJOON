package step10_GeometryRectanglesAndTriangles;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ThreeBars_14215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        br.close();

        if (a + b <= c || a + c <= b || b + c <= a) {
            int max = Math.max(a, Math.max(b, c));
            bw.write(a == max ? 2 * (b + c) - 1 + "" : b == max ? 2 * (a + c) - 1 + "" : 2 * (a + b) - 1 + "");
        } else {
            bw.write(a + b + c + "");
        }

        bw.flush();
        bw.close();

    }
}
